package com.praroop.simpleloginui.otpVerification

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider

@Composable
fun OtpScreen(navController: NavController, verificationId: String) {
    var otp by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = otp,
            onValueChange = { otp = it },
            label = { Text("Enter OTP") }
        )

        Button (onClick = {
            val credential = PhoneAuthProvider.getCredential(verificationId, otp)
            FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnSuccessListener {
                    val uid = it.user?.uid ?: ""
                    navController.navigate("home/$uid")
                }
                .addOnFailureListener {
                    Toast.makeText(context, "Invalid OTP", Toast.LENGTH_SHORT).show()
                }
        }) {
            Text("Verify OTP")
        }
    }
}
