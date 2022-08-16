package com.example.deeplinkstest.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable



@Composable
fun ComposeScreen(navController: NavHostController) {
  val startDestination = SCREEN1
  val screen2 = SCREEN2
  NavHost(
    navController = navController,
    startDestination = startDestination
  ) {
    composable(startDestination) {
      GreetingScreen(SCREEN1, onClick = { navController.navigate(screen2) })
    }
    composable(screen2) {
      GreetingScreen(screen2)
    }
  }
}

@Composable
private fun GreetingScreen(
  screenName: String = "Screen1",
  onClick: (() -> Unit)? = null
) {
  Column {

    Text(text = "$screenName")

    Spacer(modifier = Modifier.size(20.dp))

    onClick?.let {
      Button(onClick = onClick) {
        Text(text = "Load Next Screen")
      }
    }
  }
}

const val DEEP_LINK_DEST = "DeepLinkDestination"
const val SCREEN1 = "Screen1"
const val SCREEN2 = "Screen2"