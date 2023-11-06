package com.example.work8

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Screen2() {
    Text(
        modifier = Modifier.fillMaxSize().wrapContentHeight(),
        text = "Screen 2",
        textAlign = TextAlign.Center
    )
}