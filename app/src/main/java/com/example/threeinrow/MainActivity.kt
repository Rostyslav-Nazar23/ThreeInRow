package com.example.threeinrow

import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.threeinrow.ui.theme.ThreeInRowTheme

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
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PlayButton(navController)
            SettingsButton(navController)
            CreditsButton(navController)
        }
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
