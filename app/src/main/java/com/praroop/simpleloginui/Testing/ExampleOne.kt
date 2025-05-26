package com.praroop.simpleloginui.Testing

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

@Composable
fun ExampleOne(modifier: Modifier = Modifier) {
    val count= rememberSaveable { mutableStateOf(0) }
    Log.d("Count",count.value.toString())

    Button(onClick = {count.value++}) {
        Log.d("Count",count.value.toString())
        Text(text = "Click me ")

    }
    
}