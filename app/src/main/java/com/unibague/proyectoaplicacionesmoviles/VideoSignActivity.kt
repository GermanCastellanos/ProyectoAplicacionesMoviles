// VideoSignActivity.kt
package com.unibague.proyectoaplicacionesmoviles

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.unibague.proyectoaplicacionesmoviles.databinding.ActivityVideoSignBinding
import com.unibague.proyectoaplicacionesmoviles.ui.fragments.VideoSignFragment

class VideoSignActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVideoSignBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoSignBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val word = intent.getStringExtra("SIGN_WORD") ?: "Gracias"
        Log.d("VideoSignActivity", "Palabra recibida: $word")


        if (savedInstanceState == null) {
            val fragment = VideoSignFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commitNow()  // Usar commitNow() en lugar de commit()

            // Llamar a playSignVideo después de un pequeño delay
            binding.root.postDelayed({
                fragment.playSignVideo(word)
            }, 100)
        }
    }
}