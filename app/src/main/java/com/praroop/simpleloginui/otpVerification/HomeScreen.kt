package com.praroop.simpleloginui.otpVerification

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(userId: String) {
    Text("Welcome! Your Firebase UID is $userId")
}
