package com.example.work8

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.work8.di.DaggerComponent
import kotlinx.coroutines.launch
import java.time.Duration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerComponent.create().inject(this)

        val t = mutableListOf<PersonModel>()
        for (i in 0 until 200) {
            t.add(PersonModel("Baby Yoda", "Jedi"))
        }
        setContent {
            MainScreen(t = t)
            //TopBar(context = applicationContext,t)
            //Screen1(t = t)
        }
    }
}



//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun TopBar(context: Context, t:MutableList<PersonModel>) {
//
//    val coroutineScope = rememberCoroutineScope()
//    val scaffoldState = rememberScaffoldState()
//
//    Scaffold(
//        scaffoldState=scaffoldState,
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(text = "Work 8")
//                },
//                navigationIcon = {
//                    IconButton(
//                        onClick = {
//                            coroutineScope.launch {
//                                scaffoldState.drawerState.open()
//                            }
//                        }) {
//                        Icon(
//                            imageVector = Icons.Filled.Menu,
//                            contentDescription = "Menu"
//                        )
//
//                    }
//                }
//
//            )
//
//        },
//        bottomBar =  {
//            BottomAppBar (
//
//            )
//            {}
//        },
//        drawerContent = {
//            DrawerHeader()
//            DrawerBody()
//        }
//
//
//    ) {
//        Screen1(t = t)
//    }
//
//}



