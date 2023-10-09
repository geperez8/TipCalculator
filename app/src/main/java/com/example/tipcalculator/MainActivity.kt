package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import androidx.compose.ui.viewinterop.AndroidView
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.tipcalculator.R
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val calculateButton = findViewById<Button>(R.id.CalculateButton)
        calculateButton?.setOnClickListener {
            showResult()
        }
    }

    private fun calculateResult(): Double {
        val mealPriceNumber = findViewById<EditText>(R.id.MealPriceInput)
        val tipPercentageNumber = findViewById<EditText>(R.id.TipAmountInput)

        val mealPrice = mealPriceNumber?.text.toString().toDouble()

        val tipPercentage = tipPercentageNumber?.text.toString().toDouble()

        return mealPrice * (tipPercentage/100)
    }

    private fun showResult() {
        val tipAmount = calculateResult()

        val tipDisplay = findViewById<TextView>(R.id.Tip)

        val partySize = findViewById<TextView>(R.id.PartySize).text.toString().toDouble()

        val resultTip = ("%.2f".format(tipAmount/partySize))

        tipDisplay.text = "Tip: $resultTip"

        val mealPriceNumber = findViewById<EditText>(R.id.MealPriceInput)

        val mealPrice = mealPriceNumber?.text.toString().toDouble()

        val totalDisplay = findViewById<TextView>(R.id.Total)

        val resultTotal = (tipAmount + mealPrice) / partySize

        totalDisplay.text = "Total: %.2f".format(resultTotal)
    }
}

@Composable
fun MyXmlLayout() {
    AndroidView(
        factory = { context ->
            // Inflate your XML layout
            LayoutInflater.from(context).inflate(R.layout.layout, null, false)
        }
    )
}




