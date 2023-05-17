package com.priyank.dogsapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.priyank.MainViewModel
import com.priyank.dogsapp.ui.theme.PrimaryButtonColor
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun RecentScreen() {
    val vm = hiltViewModel<MainViewModel>()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LaunchedEffect(key1 = true) {
            GlobalScope.launch {
                vm.getRecentDogs()
            }
        }

        val images = vm.recents.collectAsState()

        LazyRow(modifier = Modifier.padding(10.dp).size(400.dp)) {
            items(items = images.value) {
                AsyncImage(model = it, contentDescription = "gg", modifier = Modifier.fillMaxSize().padding(10.dp), contentScale = ContentScale.Fit)
            }
        }

        Button(
            onClick = {
                GlobalScope.launch() {
                    vm.clearDogs()
                }
            },
            shape = RoundedCornerShape(50),
            border = BorderStroke(width = 1.dp, color = Color.Black),
            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryButtonColor)
        ) {
            Text(
                text = "Clear Dogs",
                modifier = Modifier.background(PrimaryButtonColor),
                color = Color.White
            )
        }
    }
}
