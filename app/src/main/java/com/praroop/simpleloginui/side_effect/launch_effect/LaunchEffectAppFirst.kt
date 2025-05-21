package com.praroop.simpleloginui.side_effect.launch_effect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class LaunchEffectAppFirst : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListComposable()
        }
    }
}

@Composable
fun ListComposable() {
    //called every time once execute this composable we are using launch effect for handle this


    val categoryState = remember { mutableStateOf(emptyList<String>()) }
    LaunchedEffect(key1=Unit ) {
        categoryState.value = fetchCategories()
    }

    LazyColumn {
        items(categoryState.value) { item ->
            Text(item)

        }
    }
}

fun fetchCategories(): List<String> {

    return listOf("One", "Two", "Three")

}