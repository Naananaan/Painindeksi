package com.example.bmiviewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class BMIViewModel : ViewModel() {
    var height by mutableStateOf("")
        private set

    var weight by mutableStateOf("")
        private set

    var bmiResult by mutableStateOf(0.0)
        private set

    fun updateHeight(newHeight: String) {
        height = newHeight
    }

    fun updateWeight(newWeight: String) {
        weight = newWeight
    }

    private fun calculateBMI() {
        val heightValue = height.toDoubleOrNull()
        val weightValue = weight.toDoubleOrNull()

        if (heightValue != null && weightValue != null && heightValue > 0) {
            bmiResult = weightValue / (heightValue * heightValue)
        }
    }

    fun getBMIResult(): Double {
        calculateBMI()
        return bmiResult
    }
}
