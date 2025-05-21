package com.praroop.simpleloginui.side_effect.launch_effect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class LaunchEffectApp :ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }

}
var counter=1
@Composable
fun HasSideEffect(){
    counter++
    Text(text ="Cheeze Code" )
}