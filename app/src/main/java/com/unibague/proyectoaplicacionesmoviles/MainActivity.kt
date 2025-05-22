/*package com.unibague.proyectoaplicacionesmoviles

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.unibague.proyectoaplicacionesmoviles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
/*
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

 */
    }
}

/*

// Todo esto es main activity, pero del Home

package com.example.home_page_intento1

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declaración de componentes UI
    private lateinit var searchIcon: ImageView
    private lateinit var searchEditText: EditText
    private lateinit var toggleButton: ImageButton
    private lateinit var banner: ImageView
    private lateinit var bannerSignIcon: ImageView
    private lateinit var tryNowButton: ImageButton

    // Contenedores de categorías
    private lateinit var recentSignsContainer: LinearLayout
    private lateinit var themesContainer: LinearLayout

    // Lista para guardar todos los overlays de señas
    private val signOverlays = mutableListOf<ImageView>()

    // Estado de la app (modo ON/OFF)
    private var isSignModeOn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar componentes
        initializeViews()

        // Configurar estado inicial (OFF)
        setSignMode(false)

        // Configurar listeners
        setupListeners()
    }

    private fun initializeViews() {
        // Barra superior
        searchIcon = findViewById(R.id.imgSearchIcon)
        searchEditText = findViewById(R.id.edtSearch)
        toggleButton = findViewById(R.id.btnToggle)

        // Banner y botón "Probar Ahora"
        banner = findViewById(R.id.imgBanner)
        bannerSignIcon = findViewById(R.id.imgBannerSignIcon)
        tryNowButton = findViewById(R.id.btnTryNow)

        // Contenedores de elementos
        recentSignsContainer = findViewById(R.id.containerRecentSigns)
        themesContainer = findViewById(R.id.containerThemes)

        // Inicializar overlays de señas
        initializeSignOverlays()
    }

    private fun initializeSignOverlays() {
        // Overlay del banner
        signOverlays.add(bannerSignIcon)

        // Overlays de "Señas Recientes"
        signOverlays.add(findViewById(R.id.overlayPear))
        signOverlays.add(findViewById(R.id.overlayWatermelon))
        signOverlays.add(findViewById(R.id.overlayTolima))
        signOverlays.add(findViewById(R.id.overlayMushroom))

        // Overlays de "Temas"
        signOverlays.add(findViewById(R.id.overlayDepartments))
        signOverlays.add(findViewById(R.id.overlayVegetables))
        signOverlays.add(findViewById(R.id.overlayFruits))

        // Overlay del botón "Probar Ahora"
        signOverlays.add(findViewById(R.id.overlayTryNow))
    }

    private fun setupListeners() {
        // Listener para el botón toggle ON/OFF
        toggleButton.setOnClickListener {
            // Cambiar el estado
            isSignModeOn = !isSignModeOn

            // Actualizar la interfaz
            setSignMode(isSignModeOn)
        }

        // Listener para el botón "Probar Ahora"
        tryNowButton.setOnClickListener {
            // TODO: Implementar la navegación a la pantalla de generar videos
        }
    }

    private fun setSignMode(isOn: Boolean) {
        if (isOn) {
            // Cambiar a modo ON
            toggleButton.setImageResource(R.drawable.ic_toggle_on)
            banner.setImageResource(R.drawable.banner_home_on)

            // Mostrar todos los iconos de señas
            signOverlays.forEach { it.visibility = View.VISIBLE }
        } else {
            // Cambiar a modo OFF
            toggleButton.setImageResource(R.drawable.ic_toggle_off)
            banner.setImageResource(R.drawable.banner_home_off)

            // Ocultar todos los iconos de señas
            signOverlays.forEach { it.visibility = View.GONE }
        }
    }
}
 */
 */

// sfnvkdnf vkjldnfkjnsdkjfndflvdfdkjfnbkjdfnlfvnfnvklbfnñlznfljñvnz

package com.unibague.proyectoaplicacionesmoviles

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declaración de componentes UI
    private lateinit var toggleButton: ImageButton
    private lateinit var banner: ImageView
    private lateinit var bannerSignIcon: ImageView
    private lateinit var tryNowButton: ImageButton

    // Contenedores de categorías
    private lateinit var recentSignsContainer: LinearLayout
    private lateinit var themesContainer: LinearLayout

    // Lista para guardar todos los overlays de señas
    private val signOverlays = mutableListOf<ImageView>()

    // Estado de la app (modo ON/OFF)
    private var isSignModeOn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar componentes
        initializeViews()

        // Configurar estado inicial (OFF)
        setSignMode(false)

        // Configurar listeners
        setupListeners()
    }

    private fun initializeViews() {
        // Inicializar componentes del banner y botones
        banner = findViewById(R.id.imgBanner)
        bannerSignIcon = findViewById(R.id.imgBannerSignIcon)
        tryNowButton = findViewById(R.id.btnTryNow)

        // Nota: Si tienes un botón toggle en tu layout, descomenta la siguiente línea
        // toggleButton = findViewById(R.id.btnToggle) // Asegúrate de que este ID exista en tu XML

        // Contenedores de elementos
        recentSignsContainer = findViewById(R.id.containerRecentSigns)
        themesContainer = findViewById(R.id.containerThemes)

        // Inicializar overlays de señas
        initializeSignOverlays()
    }

    private fun initializeSignOverlays() {
        // Overlay del banner
        val overlayTryNow = findViewById<ImageView>(R.id.overlayTryNow)
        signOverlays.add(overlayTryNow)

        // Añadir el icono del banner
        signOverlays.add(bannerSignIcon)

        // Overlays de "Señas Recientes"
        val overlayPear = findViewById<ImageView>(R.id.overlayPear)
        val overlayWatermelon = findViewById<ImageView>(R.id.overlayWatermelon)
        val overlayTolima = findViewById<ImageView>(R.id.overlayTolima)
        val overlayMushroom = findViewById<ImageView>(R.id.overlayMushroom)

        signOverlays.add(overlayPear)
        signOverlays.add(overlayWatermelon)
        signOverlays.add(overlayTolima)
        signOverlays.add(overlayMushroom)

        // Overlays de "Temas"
        val overlayDepartments = findViewById<ImageView>(R.id.overlayDepartments)
        val overlayVegetables = findViewById<ImageView>(R.id.overlayVegetables)
        val overlayFruits = findViewById<ImageView>(R.id.overlayFruits)

        signOverlays.add(overlayDepartments)
        signOverlays.add(overlayVegetables)
        signOverlays.add(overlayFruits)

        // Asegurarse de que todos los overlays comiencen ocultos
        signOverlays.forEach { it.visibility = View.GONE }
    }

    private fun setupListeners() {
        // Listener para el botón toggle ON/OFF
        // Solo configurar si el toggleButton existe
        if (::toggleButton.isInitialized) {
            toggleButton.setOnClickListener {
                // Cambiar el estado
                isSignModeOn = !isSignModeOn

                // Actualizar la interfaz
                setSignMode(isSignModeOn)
            }
        }

        // Listener para el botón "Probar Ahora"
        tryNowButton.setOnClickListener {
            // TODO: Implementar la navegación a la pantalla de generar videos
        }
    }

    private fun setSignMode(isOn: Boolean) {
        if (isOn) {
            // Cambiar a modo ON
            if (::toggleButton.isInitialized) {
                toggleButton.setImageResource(R.drawable.ic_toggle_on)
            }
            banner.setImageResource(R.drawable.banner_home_on)

            // Mostrar todos los iconos de señas
            signOverlays.forEach {
                it.visibility = View.VISIBLE
            }
        } else {
            // Cambiar a modo OFF
            if (::toggleButton.isInitialized) {
                toggleButton.setImageResource(R.drawable.ic_toggle_off)
            }
            banner.setImageResource(R.drawable.banner_home_off)

            // Ocultar todos los iconos de señas
            signOverlays.forEach {
                it.visibility = View.GONE
            }
        }
    }
}