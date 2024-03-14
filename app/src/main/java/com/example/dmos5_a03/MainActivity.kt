package com.example.dmos5_a03

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var imcTextView: TextView
    private lateinit var conditionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weightEditText = findViewById(R.id.weightEditText)
        heightEditText = findViewById(R.id.heightEditText)
        imcTextView = findViewById(R.id.imcTextView)
        conditionTextView = findViewById(R.id.conditionTextView)

        val calculateButton: Button = findViewById(R.id.calculateButton)
        calculateButton.setOnClickListener { calculateIMC() }

        val resetButton: Button = findViewById(R.id.resetButton)
        resetButton.setOnClickListener { resetFields() }
    }

    private fun calculateIMC() {
        val weightText = weightEditText.text.toString()
        val heightText = heightEditText.text.toString()

        if (weightText.isEmpty() || heightText.isEmpty()) {
            imcTextView.text = "Preencha os campos de peso e altura."
            return
        }

        val weight = weightText.toDouble()
        val height = heightText.toDouble() / 100 // Convertendo para metros

        val imc = weight / (height * height)
        val condition = when {
            imc < 18.5 -> "Abaixo do peso"
            imc < 24.9 -> "Peso normal"
            imc < 29.9 -> "Acima do peso"
            else -> "Obeso"
        }

        imcTextView.text = String.format("Seu IMC é %.2f", imc)
        conditionTextView.text = String.format("Condição: %s", condition)
    }

    private fun resetFields() {
        weightEditText.text.clear()
        heightEditText.text.clear()
        imcTextView.text = ""
        conditionTextView.text = ""
    }
}