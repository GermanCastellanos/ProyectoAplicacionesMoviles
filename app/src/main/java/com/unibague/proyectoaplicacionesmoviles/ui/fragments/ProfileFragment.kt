package com.unibague.proyectoaplicacionesmoviles

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.unibague.proyectoaplicacionesmoviles.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        auth = Firebase.auth // Initialize FirebaseAuth
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Cargar el nombre del usuario desde SharedPreferences
        val sharedPreferences = requireContext().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "Usuario") ?: "Usuario"
        binding.tvUsername.text = username

        // Listener para editar nombre
        binding.tvEditName.setOnClickListener {
            showEditNameDialog()
        }

        // Listener para cerrar sesión con confirmación
        binding.btnLogout.setOnClickListener {
            showLogoutConfirmationDialog(sharedPreferences)
        }
    }

    private fun showEditNameDialog() {
        val editText = EditText(requireContext()).apply {
            setText(binding.tvUsername.text) // Set the current username as default text
        }

        AlertDialog.Builder(requireContext())
            .setTitle("Editar Nombre")
            .setView(editText)
            .setPositiveButton("Guardar") { _, _ ->
                val newName = editText.text.toString().trim()
                if (newName.isNotEmpty()) {
                    binding.tvUsername.text = newName
                    val sharedPreferences = requireContext().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                    with(sharedPreferences.edit()) {
                        putString("username", newName)
                        apply()
                    }
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun showLogoutConfirmationDialog(sharedPreferences: android.content.SharedPreferences) {
        AlertDialog.Builder(requireContext())
            .setTitle("Confirmar cierre de sesión")
            .setMessage("¿Estás seguro de que deseas cerrar sesión?")
            .setPositiveButton("Sí") { _, _ ->
                // Sign out from Firebase
                auth.signOut()
                // Limpiar datos de sesión
                with(sharedPreferences.edit()) {
                    clear()
                    apply()
                }
                // Navegar de vuelta a LoginActivity
                val intent = Intent(requireContext(), LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                requireActivity().finish()
            }
            .setNegativeButton("No", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}