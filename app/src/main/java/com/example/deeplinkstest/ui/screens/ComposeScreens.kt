package com.example.deeplinkstest.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.deeplinkstest.ui.theme.DeepLinksTestTheme



@Composable
fun ComposeScreen(deepLinkScreen: String = "") {
  val startDestination = SCREEN1
  val screen2 = SCREEN2
  val navController = rememberNavController()
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

    if (deepLinkScreen.isNotEmpty()) {
      navController.navigate(deepLinkScreen)
    }
  }
}

@Composable
private fun GreetingScreen(
  screeName: String = "Screen1",
  onClick: (() -> Unit)? = null
) {
  Column {
    Greeting(screeName)

    onClick?.let {
      Button(onClick = onClick) {
        Text(text = "Load Next Screen")
      }
    }
  }
}



@Composable
private fun Greeting(name: String) {
  Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  DeepLinksTestTheme {
    Greeting("Android")
  }
}

const val DEEP_LINK_DEST = "DeepLinkDestination"
const val SCREEN1 = "Screen1"
const val SCREEN2 = "Screen2"