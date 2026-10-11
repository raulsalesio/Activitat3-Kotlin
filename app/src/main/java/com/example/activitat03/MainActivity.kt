package com.example.activitat03

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {


    // DECLARACIÓ DE VARIABLES
    private var isMaleSelected: Boolean = true
    private var currentWeight: Int = 70
    private var currentAge: Int = 18
    private var currentHeight: Int = 170

    // Targetes de Gènere
    private lateinit var cardMale: MaterialCardView
    private lateinit var cardFemale: MaterialCardView

    // Alçada
    private lateinit var tvHeight: TextView
    private lateinit var sliderHeight: Slider

    // Pes
    private lateinit var tvWeight: TextView
    private lateinit var btnSubWeight: ImageButton
    private lateinit var btnAddWeight: ImageButton

    // Edat
    private lateinit var tvAge: TextView
    private lateinit var btnSubAge: ImageButton
    private lateinit var btnAddAge: ImageButton

    // Botó de calcular
    private lateinit var btnCalculate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
}