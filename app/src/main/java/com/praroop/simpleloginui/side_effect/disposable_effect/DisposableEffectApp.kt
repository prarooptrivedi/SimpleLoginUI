package com.praroop.simpleloginui.side_effect.disposable_effect

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sipsplit.R

class DisposableEffectApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KeyBoardDisposable()
            TextField(value = "", onValueChange = {})
        }
    }
}

@Composable
fun App() {
    val state = remember { mutableStateOf(false) }
    DisposableEffect(key1 = state.value) {
        Log.d("Praroop Code ", "Disposable Effect Stared")
        onDispose {
            Log.d("Praroop Code ", "Cleaning up Side Eeefects")
        }

    }
    Button(onClick = {
        state.value = !state.value
    }) {
        Text("Click Me")

    }
}

@Composable
fun MediaComposable() {
    val context = LocalContext.current
    DisposableEffect(Unit) {
        val mediaPlayer = MediaPlayer.create(context, R.raw.dummy)
        mediaPlayer.start()
        onDispose {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }
}

@Composable
fun KeyBoardDisposable(){
    val context = LocalContext.current
    val view= LocalView.current
    DisposableEffect(key1 = Unit) {
        val listner=ViewTreeObserver.OnGlobalLayoutListener {
            val insets=ViewCompat.getRootWindowInsets(view)
           val isKeyboardVisible= insets.isVisible(WindowInsetsCompat.Type.ime())
            Log.d("PraroopCode",isKeyboardVisible.toString())
        }
        view.viewTreeObserver.addOnGlobalLayoutListener(listner)
        onDispose {

            view.viewTreeObserver.removeOnGlobalLayoutListener(listner)
        }
    }
}