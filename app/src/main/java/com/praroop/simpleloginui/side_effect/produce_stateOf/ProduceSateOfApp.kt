package com.praroop.simpleloginui.side_effect.produce_stateOf

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@SuppressLint("ProduceStateDoesNotAssignValue")
@Composable
fun ProduceStateOf() {
    val state = produceState(initialValue = 0) {
        for (i in 1..10) {
            delay(1000)
            value += 1
        }
    }
    Text(
        text = state.value.toString(),
        style = MaterialTheme.typography.headlineLarge
    )
}

@SuppressLint("ProduceStateDoesNotAssignValue")
@Composable
fun Loader() {
    val degree = produceState(initialValue = 0) {
        while (true){
            delay(16)
            value = (value + 20) % 360
        }

    }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f),
        content = {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                imageVector = Icons.Default.Refresh,
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .rotate(degree.value.toFloat())
            )
            Text(text = "Loading")
        }
    })

}
