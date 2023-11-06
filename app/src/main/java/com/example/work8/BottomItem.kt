package com.example.work8
import com.example.work8.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String){
    object Screen1: BottomItem("Screen 1", R.drawable.icon, "screen_1")
    object Screen2: BottomItem("Screen 2", R.drawable.icon, "screen_2")
}
