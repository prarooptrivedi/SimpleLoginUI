package com.praroop.simpleloginui.side_effect.launch_effect

import android.util.Log
import androidx.compose.material3.Button

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class LaunchEffectAppSecond : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Counter()
        }
    }
}


@Composable
fun Counter() {
    var count= remember { mutableStateOf(0) }
    var key=count.value%3==0
    LaunchedEffect(key) {
        Log.d("Counter","Current Counter :${count.value}")
    }

    Button(onClick = { count.value++}) {
        Text("Increment Count")

    }


}