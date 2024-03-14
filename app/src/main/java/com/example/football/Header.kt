package com.example.football

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun Header(text:String){
    Text(text = text,
        fontSize = 55.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()

            .background(Color.Yellow)

    )
}