package com.unibague.proyectoaplicacionesmoviles.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.unibague.proyectoaplicacionesmoviles.databinding.FragmentHomeBinding

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnLogin.setOnClickListener {
            val nombre = binding.editTextText.text.toString()
            val toast = Toast.makeText(context, "Bienvenido"+ " " + nombre, Toast.LENGTH_SHORT)
            toast.show()
        }

        auth = Firebase.auth

        binding.btnLogin.setOnClickListener {
            val nombre = binding.editTextText.text.toString()
            val contraseña = binding.editTextTextPassword.text.toString()

            auth.signInWithEmailAndPassword(nombre, contraseña).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val toast = Toast.makeText(context, "Datos correctos!", Toast.LENGTH_SHORT)
                    toast.show()
                }else{
                    val toast = Toast.makeText(context, "Datos incorrectos!", Toast.LENGTH_SHORT)
                    toast.show()
                }
                }
        }
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}