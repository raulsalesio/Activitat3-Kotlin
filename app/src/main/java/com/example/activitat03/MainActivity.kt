package com.example.activitat03

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
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
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = false
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponent()
        initListeners()
        initUI()

    }

    // Funcions Main
    private fun initComponent() {
        cardMale = findViewById(R.id.seleccio_home)
        cardFemale = findViewById(R.id.seleccio_dona)
        tvHeight = findViewById(R.id.tv_height)
        sliderHeight = findViewById(R.id.slider_height)
        tvWeight = findViewById(R.id.tv_weight)
        btnSubWeight = findViewById(R.id.btn_sub_weight)
        btnAddWeight = findViewById(R.id.btn_add_weight)
        tvAge = findViewById(R.id.tv_age)
        btnSubAge = findViewById(R.id.btn_sub_age)
        btnAddAge = findViewById(R.id.btn_add_age)
        btnCalculate = findViewById(R.id.btn_calculate)
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun changeGender(isMale: Boolean) {
        isMaleSelected = isMale
        val colorSelected = Color.parseColor("#1D1E33")
        val colorUnselected = Color.parseColor("#111328")

        if (isMaleSelected) {
            cardMale.setCardBackgroundColor(colorSelected)
            cardFemale.setCardBackgroundColor(colorUnselected)
        } else {
            cardMale.setCardBackgroundColor(colorUnselected)
            cardFemale.setCardBackgroundColor(colorSelected)
        }
    }

    private fun initUI() {
        changeGender(true)
        setWeight()
        setAge()
    }


    private fun initListeners() {
        // Selecció de gènere
        cardMale.setOnClickListener {
            changeGender(isMale = true)
        }
        cardFemale.setOnClickListener {
            changeGender(isMale = false)
        }

        // Slider d'alçada
        sliderHeight.addOnChangeListener { _, value, _ ->
            currentHeight = value.toInt()
            tvHeight.text = "$currentHeight centimeters"
        }

        // Botons de Pes
        btnSubWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnAddWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }

        // Botons d'Edat
        btnSubAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnAddAge.setOnClickListener {
            currentAge += 1
            setAge()
        }

        // Botón Calcular
        btnCalculate.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI() {
        val heightMeters = currentHeight / 100.0
        val bmi = currentWeight.toDouble() / (heightMeters * heightMeters)

        // Intent per obrir MainActivity2 y pasarli el resultat
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("EXTRA_BMI_RESULT", bmi)
        startActivity(intent)
    }
}


