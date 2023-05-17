package com.priyank.dogsapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.priyank.dogsapp.ui.theme.PrimaryButtonColor

@Composable
fun HomeScreen(onGenerateClick: () -> Unit, onRecentsClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = "Random Dog Generator!", modifier = Modifier.padding(bottom = 200.dp), fontWeight = FontWeight.Bold, fontSize = 25.sp)
        Button(
            shape = RoundedCornerShape(50),
            onClick = onGenerateClick,
            border = BorderStroke(width = 1.dp, color = Color.Black),
            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryButtonColor)
        ) {
            Text(text = "Generate Dogs", modifier = Modifier.background(PrimaryButtonColor), color = Color.White)
        }

        Button(
            shape = RoundedCornerShape(50),
            onClick = onRecentsClick,
            border = BorderStroke(width = 1.dp, color = Color.Black),
            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryButtonColor)
        ) {
            Text(text = " My Generated Dogs", modifier = Modifier.background(PrimaryButtonColor), color = Color.White)
        }
    }
}
