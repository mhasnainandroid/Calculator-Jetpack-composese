package com.example.calculatorapp

sealed class CalculatorActions {
    data class Number(val number: Int) : CalculatorActions()
    object Delete : CalculatorActions()
    object Clear : CalculatorActions()
    object Decimal : CalculatorActions()
    object Calculate : CalculatorActions()
    data class Operation(val operation: CalculatorOperations) : CalculatorActions()

}