// SignLanguageViewModel.kt
package com.unibague.proyectoaplicacionesmoviles.viewmodel

import androidx.lifecycle.ViewModel
import com.unibague.proyectoaplicacionesmoviles.R
import com.unibague.proyectoaplicacionesmoviles.data.SignLanguageVideo

class SignLanguageViewModel : ViewModel() {
    init {
        // Log para verificar que el ViewModel se crea
        android.util.Log.d("SignLanguageViewModel", "ViewModel creado")
    }

    private val signVideos = listOf(
        SignLanguageVideo(
            word = "Gracias",
            videoResourceId = R.raw.gracias,  // Sin .mp4
            category = "Cortesía"
        ),
        SignLanguageVideo(
            word = "Pera",
            videoResourceId = R.raw.pera,  // Sin .mp4
            category = "Fruta"
        ),
        SignLanguageVideo(
            word = "Sandia",
            videoResourceId = R.raw.sandia,  // Sin .mp4
            category = "Fruta"
        ),
        SignLanguageVideo(
            word = "Tolima",
            videoResourceId = R.raw.tolima,  // Sin .mp4
            category = "Departamento"
        ),
        SignLanguageVideo(
            word = "Champiñon",
            videoResourceId = R.raw.champinon,  // Sin .mp4
            category = "Comida"
        ),
        SignLanguageVideo(
            word = "aceite",
            videoResourceId = R.raw.aceite,
            category = "Comida"
        ),
        SignLanguageVideo(
            word = "arroz",
            videoResourceId = R.raw.arroz,
            category = "Comida"
        ),
        SignLanguageVideo(
            word = "arvejas amarillas",
            videoResourceId = R.raw.arvejas_amarillas,
            category = "Comida"
        ),
        SignLanguageVideo(
            word = "atun",
            videoResourceId = R.raw.atun,
            category = "Comida"
        ),
        SignLanguageVideo(
            word = "azucar",
            videoResourceId = R.raw.azucar,
            category = "Comida"
        ),
        SignLanguageVideo(
            word = "chocolate",
            videoResourceId = R.raw.chocolate,
            category = "Comida"
        ),
        SignLanguageVideo(
            word = "espagueti",
            videoResourceId = R.raw.espagueti,
            category = "Comida"
        ),
        SignLanguageVideo(
            word = "galletas",
            videoResourceId = R.raw.galletas,
            category = "Comida"
        ),
        SignLanguageVideo(
            word = "gelatina",
            videoResourceId = R.raw.gelatina,
            category = "Comida"
        ),
        SignLanguageVideo(
            word = "harina de trigo",
            videoResourceId = R.raw.harina_de_trigo,
            category = "Comida"
        ),
        SignLanguageVideo(
            word = "harina p.a.n.",
            videoResourceId = R.raw.harina_p_a_n,
            category = "Comida"
        ),
        SignLanguageVideo(
            word = "huevo",
            videoResourceId = R.raw.huevo,
            category = "Comida"
        ),
        SignLanguageVideo(
            word = "leche condensada",
            videoResourceId = R.raw.leche_condensada,
            category = "Comida"
        ),
        SignLanguageVideo(
            word = "leche en polvo",
            videoResourceId = R.raw.leche_en_polvo,
            category = "Comida"
        ),
        SignLanguageVideo(
            word = "aguacate",
            videoResourceId = R.raw.aguacate,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "banano",
            videoResourceId = R.raw.banano,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "coco",
            videoResourceId = R.raw.coco,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "curuba",
            videoResourceId = R.raw.curuba,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "fresa",
            videoResourceId = R.raw.fresa,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "granadilla",
            videoResourceId = R.raw.granadilla,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "guanaba",
            videoResourceId = R.raw.guanabana,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "guayaba",
            videoResourceId = R.raw.guayaba,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "limonada",
            videoResourceId = R.raw.limonada,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "lulo",
            videoResourceId = R.raw.lulo,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "mandarina",
            videoResourceId = R.raw.mandarina,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "mango",
            videoResourceId = R.raw.mango,
            category = "Alimentos"
        ),


        SignLanguageVideo(
            word = "maracuya",
            videoResourceId = R.raw.maracuya,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "melon",
            videoResourceId = R.raw.melon,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "mora",
            videoResourceId = R.raw.mora,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "naranja",
            videoResourceId = R.raw.naranja,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "papaya",
            videoResourceId = R.raw.papaya,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "patilla",
            videoResourceId = R.raw.patilla,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "pera",
            videoResourceId = R.raw.pera,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "pina",
            videoResourceId = R.raw.pina,
            category = "Alimentos"
        ),

        SignLanguageVideo(
            word = "antioquia",
            videoResourceId = R.raw.antioquia,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "armenia",
            videoResourceId = R.raw.armenia,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "atlantico",
            videoResourceId = R.raw.atlantico,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "barranquilla",
            videoResourceId = R.raw.barranquilla,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "bogota",
            videoResourceId = R.raw.bogota,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "bolivar",
            videoResourceId = R.raw.bolivar,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "boyaca",
            videoResourceId = R.raw.boyaca,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "bucaramanga",
            videoResourceId = R.raw.bucaramanga,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "caldas",
            videoResourceId = R.raw.caldas,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "cali",
            videoResourceId = R.raw.cali,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "capital",
            videoResourceId = R.raw.capital,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "caqueta",
            videoResourceId = R.raw.caqueta,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "cartagena",
            videoResourceId = R.raw.cartagena,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "casanare",
            videoResourceId = R.raw.casanare,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "cauca",
            videoResourceId = R.raw.cauca,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "cesar",
            videoResourceId = R.raw.cesar,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "choco",
            videoResourceId = R.raw.choco,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "colombia",
            videoResourceId = R.raw.colombia,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "cucuta",
            videoResourceId = R.raw.cucuta,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "cundinamarca",
            videoResourceId = R.raw.cundinamarca,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "departamento",
            videoResourceId = R.raw.departamento,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "florencia",
            videoResourceId = R.raw.florencia,
            category = "Departamentos o ciudades"
        ),


        SignLanguageVideo(
            word = "guaviare",
            videoResourceId = R.raw.guaviare,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "huila",
            videoResourceId = R.raw.huila,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "ibague",
            videoResourceId = R.raw.ibague,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "leticia",
            videoResourceId = R.raw.leticia,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "magdalena",
            videoResourceId = R.raw.magdalena,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "manizales",
            videoResourceId = R.raw.manizales,
            category = "Departamentos o ciudades"
        ),

        SignLanguageVideo(
            word = "medellin",
            videoResourceId = R.raw.medellin,
            category = "Departamentos o ciudades"
        )
        )

    fun getVideoForWord(word: String): SignLanguageVideo? {
        return signVideos.find { it.word.equals(word, ignoreCase = true) }
    }

    fun getAllVideos() = signVideos

    fun getVideosByCategory(category: String) =
        signVideos.filter { it.category == category }
}