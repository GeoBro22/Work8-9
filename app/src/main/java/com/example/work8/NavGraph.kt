package com.example.work8

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navHostController: NavHostController,
    t: MutableList<PersonModel>
) {
    NavHost(navController = navHostController, startDestination = "screen_1"){
        composable("screen_1"){
            Screen1(t)

        }
        composable("screen_2"){
            Screen2()
        }
    }
}