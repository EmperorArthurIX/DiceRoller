package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Getting Interaction Items
        val rollButton: Button = findViewById(R.id.rollDice)
        val resultTextView: TextView = findViewById(R.id.rollValue)

        // Interaction Responses
        rollButton.setOnClickListener {
//            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            resultTextView.text = Dice().roll().toString()
        }
    }
}

class Dice(private val sides: Int = 6) {
    private val diceRange: IntRange = 1..this.sides

    fun roll(): Int {
        // Returns the value obtained by choosing an integer from `diceRange` at random
        return diceRange.random()
    }
}