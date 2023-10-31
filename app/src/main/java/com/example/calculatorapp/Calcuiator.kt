package com.example.calculatorapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorapp.ui.theme.LightGrey
import com.example.calculatorapp.ui.theme.Orange

@Composable
fun Calculator(
    modifier: Modifier = Modifier,
    state: CalculatorState,
    bottomSpacing: Dp = 8.dp,
    onAction: (CalculatorActions) -> Unit
) {

    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(bottomSpacing)
        ) {
            Text(
                text = state.number1 + (state.calculatorOperations?.symbol?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                fontWeight = FontWeight.Light,
                fontSize = 40.sp,
                color = Color.White,
                maxLines = 2
            )
            //Buttons
            Row(horizontalArrangement = Arrangement.spacedBy(bottomSpacing)) {
                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(LightGrey)
                        .aspectRatio(2F)
                        .weight(2F),
                    onClick = {
                        onAction(CalculatorActions.Clear)
                    }
                )
                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .background(LightGrey)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalculatorActions.Delete)
                    }
                )
                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperations.Divide))
                    }
                )
            }
            //Second Row
            Row(horizontalArrangement = Arrangement.spacedBy(bottomSpacing)) {
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalculatorActions.Number(7))
                    }
                )
                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalculatorActions.Number(8))
                    }
                )
                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalculatorActions.Number(9))
                    }
                )
                CalculatorButton(
                    symbol = "x",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperations.Multiply))
                    }
                )
            }

            //Third Row
            Row(horizontalArrangement = Arrangement.spacedBy(bottomSpacing)) {
                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalculatorActions.Number(4))
                    }
                )
                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalculatorActions.Number(5))
                    }
                )
                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalculatorActions.Number(6))
                    }
                )
                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperations.Subtract))
                    }
                )
            }
            //Fourth Row
            Row(horizontalArrangement = Arrangement.spacedBy(bottomSpacing)) {
                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalculatorActions.Number(1))
                    }
                )
                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalculatorActions.Number(2))
                    }
                )
                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalculatorActions.Number(3))
                    }
                )
                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperations.Add))
                    }
                )
            }
            //Fifth Row
            Row(horizontalArrangement = Arrangement.spacedBy(bottomSpacing)) {
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(2F)
                        .weight(2F),
                    onClick = {
                        onAction(CalculatorActions.Number(0))
                    }
                )
                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalculatorActions.Decimal)
                    }
                )
                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalculatorActions.Calculate)
                    }
                )
            }
        }
    }
}












