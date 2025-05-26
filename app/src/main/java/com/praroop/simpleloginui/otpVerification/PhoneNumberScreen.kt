package com.praroop.simpleloginui.otpVerification

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
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
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

@Composable
fun PhoneNumberScreen(navController: NavController) {
    var phoneNumber by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val context = LocalContext.current
    if (isLoading) {
        AlertDialog(
            onDismissRequest = {},
            confirmButton = {},
            title = { Text("Please wait") },
            text = {
                Row  {
                    CircularProgressIndicator(modifier = Modifier.padding(end = 16.dp))
                    Text("Sending OTP...")
                }
            }
        )
    }
    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Enter phone number") }
        )

        Button(onClick = {
            isLoading = true
            val options = PhoneAuthOptions.newBuilder(FirebaseAuth.getInstance())
                .setPhoneNumber("+91$phoneNumber") // adjust for country code
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(context as Activity)
                .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                        // Auto-retrieval or instant verification
                        FirebaseAuth.getInstance().signInWithCredential(credential)
                            .addOnSuccessListener {
                                val uid = it.user?.uid ?: ""
                                navController.navigate("home/$uid")
                            }
                    }

                    override fun onVerificationFailed(e: FirebaseException) {
                        isLoading = false
                        Toast.makeText(context, "Verification Failed: ${e.message}", Toast.LENGTH_SHORT).show()
                    }

                    override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
                        isLoading = false
                        navController.navigate("otp/$verificationId")
                    }
                })
                .build()
            PhoneAuthProvider.verifyPhoneNumber(options)
        }) {
            Text("Send OTP")
        }
    }
}
