package com.example.threeinrow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            LocalContext.current
            NavHost(navController = navController, startDestination = "Main Screen") {
                composable("Main Screen") {
                    MainScreen(navController)
                }
                composable("Settings") {
                    SettingsScreen(navController)
                }
                composable("Levels") {
                    /*TODO*/
                }
                composable("Game") {
                    /*TODO*/
                }
                composable("Pause Menu") {
                    /*TODO*/
                }
                composable("Credits") {
                    CreditsScreen(navController)
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        PlayButton(navController)
        SettingsButton(navController)
        CreditsButton(navController)
    }
}

@Composable
fun SettingsScreen(navController: NavController) {
    /*TODO*/
}

@Composable
fun CreditsScreen(navController: NavController) {
    /*TODO*/
}

@Composable
fun PlayButton(navController: NavController) {
    Button(onClick = {
        navController.navigate("Levels")
    }) {
        Text(text = "Play")
    }
}

@Composable
fun SettingsButton(navController: NavController) {
    Button(onClick = {
        navController.navigate("Settings")
    }) {
        Text(text = "Settings")
    }
}

@Composable
fun CreditsButton(navController: NavController) {
    Button(onClick = {
        navController.navigate("Credits")
    }) {
        Text(text = "Credits")
    }
}
