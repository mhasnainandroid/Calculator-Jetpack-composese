package com.example.calculatorapp

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(actions: CalculatorActions) {
        when (actions) {
            is CalculatorActions.Number -> enterNumber(actions.number)
            is CalculatorActions.Decimal -> enterDecimal()
            is CalculatorActions.Clear -> state = CalculatorState()
            is CalculatorActions.Operation -> enterOperations(actions.operation)
            is CalculatorActions.Calculate -> performCalculation()
            is CalculatorActions.Delete -> performDeletion()
        }
    }

    private fun enterOperations(operation: CalculatorOperations) {
        if (state.number1.isNotBlank() && state.number2.isBlank()) {
            state = state.copy(calculatorOperations = operation)
            Log.d("1","444422")
            return
        }
        if (state.number1.isNotBlank() && state.number2.isNotBlank()){
            Log.d("2","22222")
            performCalculation()
            state = state.copy(calculatorOperations = operation)
        }
    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.calculatorOperations != null -> state = state.copy(
                calculatorOperations = null
            )

            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun enterDecimal() {
        if (state.calculatorOperations == null && !state.number1.contains(".")
            && state.number1.isNotBlank()
        ) {
            state = state.copy(number1 = state.number1 + ".")
            return
        }

        if (!state.number2.contains(".")
            && state.number2.isNotBlank()
        ) {
            state = state.copy(number2 = state.number2 + ".")
            return
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1!=null && number2!=null){
            val result = when (state.calculatorOperations) {
                is CalculatorOperations.Add -> number1 + number2
                is CalculatorOperations.Subtract -> number1 - number2
                is CalculatorOperations.Multiply -> number1 * number2
                is CalculatorOperations.Divide -> number1 / number2
                null-> return
            }
            state = state.copy(
                number1 = result.toString().take(8),
                number2 = "",
                calculatorOperations = null
            )
        }
    }

    private fun enterNumber(number: Int) {
        if (state.calculatorOperations == null) {
            if (state.number1.length >= MAX_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length >= MAX_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    companion object {
        private const val MAX_LENGTH = 8
    }
}