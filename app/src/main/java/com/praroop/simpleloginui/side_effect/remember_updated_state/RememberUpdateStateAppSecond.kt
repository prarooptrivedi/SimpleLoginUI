package com.praroop.simpleloginui.side_effect.remember_updated_state

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

class RememberUpdateStateAppSecond : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Apps()
        }
    }
}

fun a() {
    Log.d("PraroopOne", "I am A  from app")
}

fun b() {
    Log.d("PraroopOne", "I am B from app")
}

@Composable
fun Apps() {
    var state = remember { mutableStateOf(::a) }
    Button(onClick = {
        state.value = ::b
    }) {
        Text(text = "Click to change state")
    }
    LandingScreen(state.value)

}

@Composable
fun LandingScreen(onTimeOut:()->Unit) {
    val currentOnTimeout= rememberUpdatedState(onTimeOut)
    LaunchedEffect(true) {
        delay(1000)
        currentOnTimeout.value()
    }

}
