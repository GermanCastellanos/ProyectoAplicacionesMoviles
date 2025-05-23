package com.unibague.proyectoaplicacionesmoviles.ui.fragments

import android.content.ContentResolver
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.PlaybackException
import androidx.media3.exoplayer.ExoPlayer
import com.unibague.proyectoaplicacionesmoviles.databinding.FragmentVideoSignBinding
import com.unibague.proyectoaplicacionesmoviles.viewmodel.SignLanguageViewModel

class VideoSignFragment : Fragment() {
    private var _binding: FragmentVideoSignBinding? = null
    private val binding get() = _binding!!

    private var player: ExoPlayer? = null
    private val viewModel: SignLanguageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoSignBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializePlayer()
    }

    private fun initializePlayer() {
        player = ExoPlayer.Builder(requireContext())
            .build()
            .also { exoPlayer ->
                binding.playerView.player = exoPlayer
                exoPlayer.repeatMode = Player.REPEAT_MODE_ONE
                exoPlayer.volume = 1.0f

                exoPlayer.addListener(object : Player.Listener {
                    override fun onPlayerError(error: PlaybackException) {
                        Log.e("VideoSignFragment", "Error al reproducir: ${error.message}")
                        Toast.makeText(context, "Error al reproducir el video", Toast.LENGTH_SHORT).show()
                    }

                    override fun onPlaybackStateChanged(playbackState: Int) {
                        when (playbackState) {
                            Player.STATE_READY -> {
                                Log.d("VideoSignFragment", "Video listo para reproducir")
                            }
                            Player.STATE_ENDED -> {
                                Log.d("VideoSignFragment", "Video terminado")
                            }
                        }
                    }
                })
            }
    }

    fun playSignVideo(word: String) {
        Log.d("VideoSignFragment", "Intentando reproducir video para: $word")

        viewModel.getVideoForWord(word)?.let { sign ->
            try {
                // VERIFICAR QUE EL RECURSO EXISTE
                val resourceId = sign.videoResourceId
                Log.d("VideoSignFragment", "Resource ID: $resourceId")

                // Verificar que el recurso existe
                try {
                    val resourceName = resources.getResourceEntryName(resourceId)
                    Log.d("VideoSignFragment", "Nombre del recurso: $resourceName")
                } catch (e: Exception) {
                    Log.e("VideoSignFragment", "El recurso no existe!")
                    return
                }

                // FORMA 1: La más simple y directa
                val uri = Uri.parse("android.resource://${requireContext().packageName}/$resourceId")
                Log.d("VideoSignFragment", "URI del video: $uri")

                val mediaItem = MediaItem.fromUri(uri)

                player?.apply {
                    setMediaItem(mediaItem)
                    prepare()
                    play()
                }

                binding.wordTextView.text = sign.word

            } catch (e: Exception) {
                Log.e("VideoSignFragment", "Error al configurar video: ${e.message}")
                e.printStackTrace()
            }
        } ?: run {
            Log.e("VideoSignFragment", "No se encontró video para: $word")
        }
    }

    override fun onPause() {
        super.onPause()
        player?.pause()
    }

    override fun onResume() {
        super.onResume()
        player?.play()
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
        player = null
        _binding = null
    }
}