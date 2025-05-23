// HomeFragment.kt
package com.unibague.proyectoaplicacionesmoviles.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.unibague.proyectoaplicacionesmoviles.VideoSignActivity
import com.unibague.proyectoaplicacionesmoviles.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        // Para cada elemento clickeable
        binding.frameLayoutPear?.setOnClickListener {
            openVideoActivity("Pera")
        }

        binding.frameLayoutWatermelon?.setOnClickListener {
            openVideoActivity("Sandia")
        }

        binding.frameLayoutTolima?.setOnClickListener {
            openVideoActivity("Tolima")
        }

        binding.frameLayoutMushroom?.setOnClickListener {
            openVideoActivity("Champiñon")
        }


    }

    private fun openVideoActivity(word: String) {
        val intent = Intent(requireContext(), VideoSignActivity::class.java).apply {
            putExtra("SIGN_WORD", word)
        }
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}