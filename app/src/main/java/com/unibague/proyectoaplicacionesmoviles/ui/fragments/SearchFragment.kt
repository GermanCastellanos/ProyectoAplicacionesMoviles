package com.unibague.proyectoaplicacionesmoviles

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.unibague.proyectoaplicacionesmoviles.databinding.FragmentSearchBinding
import java.text.Normalizer
import java.util.Locale

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val wordDatabase = mutableMapOf<String, Pair<Int, String>>() // palabra -> (número, tema)
    private val themeCategories = mutableMapOf<String, MutableList<Pair<Int, String>>>() // tema -> lista de (número, palabra)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeDatabase()
        setupSearchFunctionality()
        showDefaultView()
    }

    private fun initializeDatabase() {
        // Match words from SignLanguageViewModel.kt
        val wordsData = mapOf(
            "Alimentos" to listOf(
                "aceite", "arroz", "arvejas amarillas", "atun", "azucar", "Champiñon", "chocolate", "espagueti", "galletas",
                "gelatina", "harina de trigo", "harina p.a.n.", "huevo", "leche condensada", "leche en polvo"
            ),
            "Frutas" to listOf(
                "aguacate",
                "banano",
                "coco",
                "curuba",
                "fresa",
                "granadilla",
                "guanaba",
                "guayaba",
                "limonada",
                "lulo",
                "mandarina",
                "mango",
                "manzana roja-verde",
                "maracuya",
                "melon",
                "mora",
                "naranja",
                "papaya",
                "patilla",
                "pera",
                "pina",
                "tomate de arbol",
                "uva negro-rojo-verde"
            ),
            "Departamentos o ciudades" to listOf(
                "amazonas",
                "antioquia",
                "arauca",
                "armenia",
                "atlantico",
                "barranquilla",
                "bogota",
                "bolivar",
                "boyaca",
                "bucaramanga",
                "caldas",
                "cali",
                "capital",
                "caqueta",
                "cartagena",
                "casanare",
                "cauca",
                "cesar",
                "choco",
                "colombia",
                "cucuta",
                "cundinamarca",
                "departamento",
                "florencia",
                "guainia",
                "guaviare",
                "huila",
                "ibague",
                "leticia",
                "magdalena",
                "manizales",
                "medellin"
            )


        )

        var wordNumber = 1
        wordsData.forEach { (theme, words) ->
            themeCategories[theme] = mutableListOf()
            words.forEach { word ->
                wordDatabase[word.lowercase()] = Pair(wordNumber, theme)
                themeCategories[theme]?.add(Pair(wordNumber, word))
                wordNumber++
            }
        }
    }

    private fun setupSearchFunctionality() {
        binding.edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s?.toString()?.trim() ?: ""
                if (query.isEmpty()) {
                    showDefaultView()
                } else {
                    performSearch(query)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun normalizeText(text: String): String {
        return Normalizer.normalize(text, Normalizer.Form.NFD)
            .replace(Regex("[\\p{InCombiningDiacriticalMarks}]"), "")
            .lowercase(Locale.getDefault())
    }

    private fun performSearch(query: String) {
        val normalizedQuery = normalizeText(query)
        val foundWords = mutableListOf<Triple<Int, String, String>>() // número, palabra, tema
        val foundThemes = mutableSetOf<String>()

        wordDatabase.forEach { (word, data) ->
            val normalizedWord = normalizeText(word)
            if (normalizedWord.contains(normalizedQuery)) {
                foundWords.add(Triple(data.first, word, data.second))
                foundThemes.add(data.second)
            }
        }

        showSearchResults(query, foundWords, foundThemes.toList())
    }

    private fun showSearchResults(query: String, foundWords: List<Triple<Int, String, String>>, foundThemes: List<String>) {
        binding.frameLayoutBanner.visibility = View.GONE
        binding.txtSearchResults.visibility = View.VISIBLE
        binding.txtThemeResults.visibility = View.VISIBLE
        binding.txtSearchResults.text = "${foundWords.size} señas relacionadas con: \"$query\"."
        binding.txtThemeResults.text = "${foundThemes.size} temas relacionados con: \"$query\"."
        updateSignsList(foundWords)
        binding.scrollThemes.visibility = View.GONE
    }

    private fun showDefaultView() {
        binding.frameLayoutBanner.visibility = View.VISIBLE
        binding.txtSearchResults.visibility = View.GONE
        binding.txtThemeResults.visibility = View.GONE
        binding.scrollThemes.visibility = View.VISIBLE
        // Mostrar todas las señas por defecto (algunas de ejemplo)
        val defaultWords = listOf(
            Triple(46, "chocolate", "Alimentos"),
            Triple(233, "mora", "Frutas"),
            Triple(265, "ibague", "Departamentos/ciudades"),
            Triple(373, "atun", "Alimentos"),
            Triple(434, "mango", "Frutas")
        )
        updateSignsList(defaultWords)

    }

    private fun updateSignsList(words: List<Triple<Int, String, String>>) {
        binding.containerSigns.removeAllViews()
        words.forEach { (number, word, theme) ->
            val signItem = createSignItem(number, word, theme)
            binding.containerSigns.addView(signItem)
        }
    }

    private fun createSignItem(number: Int, word: String, theme: String): View {
        val linearLayout = LinearLayout(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                bottomMargin = dpToPx(8)
            }
            orientation = LinearLayout.HORIZONTAL
            setPadding(dpToPx(16), dpToPx(16), dpToPx(16), dpToPx(16))
            setBackgroundResource(R.drawable.sign_item_background)
            gravity = android.view.Gravity.CENTER_VERTICAL
        }

        val numberTextView = TextView(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(dpToPx(40), LinearLayout.LayoutParams.WRAP_CONTENT)
            text = "$number."
            setTextColor(resources.getColor(android.R.color.darker_gray, null))
            textSize = 16f
        }

        val wordTextView = TextView(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f).apply {
                marginStart = dpToPx(16)
            }
            text = word
            setTextColor(resources.getColor(android.R.color.black, null))
            textSize = 16f
            setTypeface(null, android.graphics.Typeface.BOLD)
        }

        val themeTextView = TextView(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            text = "($theme)"
            setTextColor(resources.getColor(android.R.color.darker_gray, null))
            textSize = 14f
        }

        val overlayIcon = android.widget.ImageView(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(dpToPx(24), dpToPx(24)).apply {
                marginStart = dpToPx(8)
            }
            setImageResource(R.drawable.ic_sign_overlay)
            visibility = View.GONE
        }

        linearLayout.addView(numberTextView)
        linearLayout.addView(wordTextView)
        linearLayout.addView(themeTextView)
        linearLayout.addView(overlayIcon)

        linearLayout.setOnClickListener {
            openVideoActivity(word)
        }

        return linearLayout
    }

    private fun openVideoActivity(word: String) {
        val intent = Intent(requireContext(), VideoSignActivity::class.java).apply {
            putExtra("SIGN_WORD", word)
        }
        startActivity(intent)
    }


    private fun dpToPx(dp: Int): Int {
        return (dp * resources.displayMetrics.density).toInt()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}