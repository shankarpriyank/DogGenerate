package com.priyank.dogsapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.priyank.MainViewModel
import com.priyank.dogsapp.ui.theme.PrimaryButtonColor

@Composable
fun GenerateDogsScreen() {
    val vm = hiltViewModel<MainViewModel>()
    Column() {
        AsyncImage(model = vm.imageUrl, contentDescription = "Image", modifier = Modifier.padding(bottom = 60.dp))
        Button(
            onClick = { vm.getDogs() },
            border = BorderStroke(width = 1.dp, color = Color.Black),
            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryButtonColor)
        ) {
            Text(text = "Generate Dog", modifier = Modifier.background(PrimaryButtonColor))
        }
    }
}
