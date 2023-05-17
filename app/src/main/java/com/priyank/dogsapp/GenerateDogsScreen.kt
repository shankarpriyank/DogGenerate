package com.priyank.dogsapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.priyank.MainViewModel
import com.priyank.dogsapp.ui.theme.PrimaryButtonColor
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun GenerateDogsScreen() {
    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        val vm = hiltViewModel<MainViewModel>()
        val imageUrl = vm.imageUrl.collectAsState()
        val isEnabled = vm.state.collectAsState()

        AsyncImage(
            model = imageUrl.value, contentDescription = "gg",
            modifier = Modifier
                .size(500.dp)
                .padding(50.dp),
            contentScale = ContentScale.Fit
        )

        Button(
            enabled = isEnabled.value,
            shape = RoundedCornerShape(50),
            onClick = { GlobalScope.launch { vm.getDogs() } },
            border = BorderStroke(width = 1.dp, color = Color.Black),
            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryButtonColor),
        ) {
            Text(text = "Generate Dog", modifier = Modifier, color = Color.White)
        }
    }
}
