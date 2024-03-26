package com.example.football

import MapScreen
import MyApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "myApp") {
                composable("myApp") { MyApp(navController) }
                // Pass navController to OtherScreen
                composable("mapScreen") { MapScreen(navController) }
            }
        }
    }
}
