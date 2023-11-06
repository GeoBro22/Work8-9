package com.example.work8

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.launch

@Composable
fun DrawerHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
    )
    {
        Text(
            text = "Drawer header",
            fontSize = 20.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerBody(navController: NavController, scaffoldState: ScaffoldState) {
    val listItems = listOf(
        BottomItem.Screen1,
        BottomItem.Screen2
    )
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(modifier = Modifier.fillMaxWidth()){
        itemsIndexed(listItems){ index, item ->
            NavigationDrawerItem(
                label = {
                        Text(text = "Screen ${index+1}")
                },
                selected = currentRoute == item.route,
                onClick = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                    navController.navigate(item.route) }
            )


        }
    }
}