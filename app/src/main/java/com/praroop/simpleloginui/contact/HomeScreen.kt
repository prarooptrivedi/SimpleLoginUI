package com.praroop.simpleloginui.contact

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(selected: List<Contact>, onClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = onClick) {
            Text("Click me to get contact")
        }

        if (selected.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Selected Contacts:")
            Text(selected.joinToString(", ") { it.name })
            Text(selected.joinToString(", ") { it.phone })
        }
    }
}