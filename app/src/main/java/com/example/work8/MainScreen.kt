package com.example.work8

import android.annotation.SuppressLint
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(t:MutableList<PersonModel>) {
    val navController = rememberNavController()

    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    Scaffold(
        scaffoldState=scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = currentRoute.toString())
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            coroutineScope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu"
                        )

                    }
                }

            )

        },
        bottomBar = {
            BottomNavigate(navController = navController)
        },

        drawerContent = {
            DrawerHeader()
            DrawerBody(navController,scaffoldState)
        }
    ) {
        NavGraph(navHostController = navController, t = t)
    }
}