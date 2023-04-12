package com.example.threeinrow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO Create a Thread for music, which will be affected from a Settings Screen
        setContent {
            Surface(modifier = Modifier.fillMaxSize()) {
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
                        /*TODO Navigation to Game, use a level settings and objective*/
                    }
                    composable("Game") {
                        /*TODO Start a Thread with a gameplay*/
                    }
                    composable("Pause Menu") {
                        /*TODO Pause gameplay Thread, show a Pause Menu*/
                    }
                    composable("Credits") {
                        CreditsScreen(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        PlayButton(navController)
        SettingsButton(navController)
        CreditsButton(navController)
    }
}

@Composable
fun LevelsScreen(navController: NavController) {
    /*TODO A set of Buttons, which navigate to a gameplay screen with a level parameters*/
}

@Composable
fun SettingsScreen(navController: NavController) {
    /*TODO Create a Seekbar to change music volume, a button to reset a progress*/
}

@Composable
fun CreditsScreen(navController: NavController) {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(30))
                .width(IntrinsicSize.Max)
                .height(270.dp)
                .verticalScroll(rememberScrollState())
                .background(color = Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Spacer(Modifier.height(128.dp))
            Text(
                "Rostyslav Nazarenko",
                fontSize = 30.sp
            )
            Text(
                "John Smith",
                fontSize = 30.sp
            )
            Text(
                "Jack Jackson",
                fontSize = 30.sp
            )
            Spacer(Modifier.height(128.dp))
        }
    }
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
