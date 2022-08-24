package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Getting Interaction Items
        val rollButton: Button = findViewById(R.id.rollDice)
//        val resultTextView: TextView = findViewById(R.id.rollValue)
        val diceImage: ImageView = findViewById(R.id.rollState)

        // Interaction Responses
        rollButton.setOnClickListener {
//            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
//            resultTextView.text = Dice().roll().toString()
            rollDice(diceImage)
        }
    }

    fun rollDice(diceImage: ImageView)
    {
        val diceRoll = Dice().roll().toString()
        val drawableResource = when(diceRoll) {
            "1" -> R.drawable.dice_1
            "2" -> R.drawable.dice_2
            "3" -> R.drawable.dice_3
            "4" -> R.drawable.dice_4
            "5" -> R.drawable.dice_5
            "6" -> R.drawable.dice_6

            // Default
            else -> {R.drawable.dice_3}
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll
    }
}

class Dice(private val sides: Int = 6) {
    private val diceRange: IntRange = 1..this.sides

    fun roll(): Int {
        // Returns the value obtained by choosing an integer from `diceRange` at random
        return diceRange.random()
    }
}