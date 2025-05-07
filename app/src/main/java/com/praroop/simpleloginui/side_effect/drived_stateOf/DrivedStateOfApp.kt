package com.praroop.simpleloginui.side_effect.drived_stateOf

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@SuppressLint("UnrememberedMutableState", "ProduceStateDoesNotAssignValue")
@Composable
fun DrivedStateOf(modifier: Modifier = Modifier) {
    val tableOf= remember { mutableStateOf(5) }
    val index= produceState(initialValue = 1) {

        repeat(9){
            delay(1000)
            value +=1
        }
    }
    val message = derivedStateOf {
        "${tableOf.value}* ${index.value}=${tableOf.value*index.value}"
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        Text(text = message.value.toString(),
            style = MaterialTheme.typography.headlineLarge)
    }

}