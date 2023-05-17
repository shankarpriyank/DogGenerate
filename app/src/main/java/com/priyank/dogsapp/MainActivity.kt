package com.priyank.dogsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.priyank.dogsapp.ui.theme.DogsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    //
                    //    val vm = hiltViewModel<MainViewModel>()
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Route.MAIN
                    ) {

                        composable(Route.MAIN) {

                            HomeScreen(onGenerateClick = { navController.navigate(Route.GENERATEDOGS) }, onRecentsClick = { navController.navigate(Route.RECENTS) })
                        }
                        composable(Route.GENERATEDOGS) {

                            GenerateDogsScreen()
                        }
                        composable(Route.RECENTS) {
                            RecentScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DogsAppTheme {
        Greeting("Android")
    }
}
