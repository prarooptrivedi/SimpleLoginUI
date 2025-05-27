package com.praroop.simpleloginui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.FirebaseApp
import com.praroop.login.presention.components.AuthButton
import com.praroop.simpleloginui.LoginScreen.LoginScreen
import com.praroop.simpleloginui.Testing.ExampleOne
import com.praroop.simpleloginui.contact.ContactAppNavigator
import com.praroop.simpleloginui.side_effect.drived_stateOf.DrivedStateOf
import com.praroop.simpleloginui.ui.theme.SimpleLoginUITheme
import com.praroop.simpleloginui.ui.theme.orange
import com.praroop.simpleloginui.ui.theme.white

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        FirebaseApp.initializeApp(this) // ✅ Add this line
        setContent {
            SimpleLoginUITheme {

//                ContactAppNavigator()
//                ProduceStateOf()
//                DrivedStateOf()
//                AuthButton(
//                    text = "Login",
//                    backGroundColor = orange,
//                    contentColor = white,
//                    onButtonClick = {},
//                    isLoading = true,
//                    modifier = Modifier.fillMaxWidth()
//                )
            }
        }
    }
}

