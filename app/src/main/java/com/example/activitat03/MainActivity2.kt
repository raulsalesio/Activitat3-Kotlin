package com.example.activitat03

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    // DECLARACIÓ VARIABLES
    private lateinit var tv_result: TextView
    private lateinit var btnRecalculate: Button
    private lateinit var btnBack: ImageView
    private lateinit var tvResultCategory: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponent()
    }

    private fun initComponent() {
        tv_result = findViewById(R.id.tv_result_number)
        tvResultCategory = findViewById(R.id.tv_result_category)
        btnRecalculate = findViewById(R.id.btn_recalculate)
        btnBack = findViewById(R.id.back_button)
    }

    private fun setBMI(result: Double) {
        tv_result.text = String.format("%.2f", result)

        when {
            result < 18.5 -> {
                tvResultCategory.text = "UNDERWEIGHT"
                tvResultCategory.setTextColor(Color.parseColor("#FFA500"))
            }

            result < 25.0 -> {
                tvResultCategory.text = "NORMAL"
                tvResultCategory.setTextColor(Color.parseColor("#24D876"))
            }

            result < 30.0 -> {
                tvResultCategory.text = "OVERWEIGHT"
                tvResultCategory.setTextColor(Color.parseColor("#FFA500"))
            }

            else -> {
                tvResultCategory.text = "OBESITY"
                tvResultCategory.setTextColor(Color.parseColor("#FF0000"))
            }
        }
    }
}