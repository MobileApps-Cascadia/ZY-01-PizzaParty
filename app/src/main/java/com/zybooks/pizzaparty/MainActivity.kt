package com.zybooks.pizzaparty

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

const val SLICES_PER_PIZZA = 8

class MainActivity : AppCompatActivity() {

    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Access to the UI View objects
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)
    }

    fun calculateClick(view: View) {
        // Get the number of people from the UI (as an Int)
        val numAttendStr = numAttendEditText.text.toString()
        val numAttend = numAttendStr.toIntOrNull() ?: 0//TODO: When does this cause app to crash? Fix this
"Calls for an int or else it crashes"



        // Calculate the number of pizzas needed (as an Int)
        val slicesPerPerson = 4 //TODO: Update this value to use the RadioGroup Input
        val totalPizzas = ceil(numAttend * slicesPerPerson / SLICES_PER_PIZZA.toDouble()).toInt()

        // Place totalPizzas into the string resource and display
        numPizzasTextView.text = "Total pizzas: $totalPizzas"
    }
}