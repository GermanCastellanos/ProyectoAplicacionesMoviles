package com.unibague.proyectoaplicacionesmoviles

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unibague.proyectoaplicacionesmoviles.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.unibague.proyectoaplicacionesmoviles.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentFragmentTag: String? = null
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        // Add AuthStateListener to detect sign-out
        auth.addAuthStateListener { firebaseAuth ->
            if (firebaseAuth.currentUser == null) {
                // User is signed out, redirect to LoginActivity
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
        }

        // Mostrar HomeFragment por defecto
        if (savedInstanceState == null) {
            showFragment(HomeFragment(), "HomeFragment")
        }

        // Configurar BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    showFragment(HomeFragment(), "HomeFragment")
                    true
                }
                R.id.navigation_learn -> {
                    showFragment(SearchFragment(), "LearnFragment")
                    true
                }
                R.id.navigation_profile -> {
                    showFragment(ProfileFragment(), "ProfileFragment")
                    true
                }
                else -> false
            }
        }
    }

    private fun showFragment(fragment: androidx.fragment.app.Fragment, tag: String) {
        // Evitar recargar el mismo fragment
        if (currentFragmentTag == tag) return

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment, tag)
        transaction.addToBackStack(null) // Opcional: permite regresar al fragment anterior con el botón "atrás"
        transaction.commit()
        currentFragmentTag = tag
    }

    override fun onDestroy() {
        super.onDestroy()
        // Clean up AuthStateListener if needed (optional, as Firebase manages it)
    }
}