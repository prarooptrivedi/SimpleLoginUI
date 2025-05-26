package com.praroop.simpleloginui.LoginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.praroop.simpleloginui.R
import com.praroop.simpleloginui.ui.theme.Black
import com.praroop.simpleloginui.ui.theme.BlueGray


@Composable
fun LoginScreen() {
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            TopSection()
            Spacer(modifier = Modifier.height(36.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
            ) {
                LoginSection()
                Spacer(modifier = Modifier.height(30.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Or countine With",
                        style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFF647488)),

                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SocialMediaLogin(icon = R.drawable.google, text = "Google", modifier = Modifier.weight(1f), onClick = {})
                        Spacer(modifier = Modifier.width(20.dp))
                        SocialMediaLogin(icon = R.drawable.facebook, text = "Facebook", modifier = Modifier.weight(1f), onClick = {})
                    }

                }
            }
        }
    }

}

@Composable
private fun LoginSection() {
    LoginTextField(label = "Email", traling = "", modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(15.dp))
    LoginTextField(label = "Password", traling = "Forget", modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(20.dp))
    Button(
        modifier = Modifier.height(40.dp).fillMaxWidth(),
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = if (!isSystemInDarkTheme()) BlueGray else Black,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(size = 4.dp)
    ) {
        Text(
            text = "Log in",
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium)
        )
    }
}

@Composable
private fun TopSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.45f),
            painter = painterResource(id = R.drawable.shape),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Row(
            modifier = Modifier.padding(top = 80.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(42.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                tint = uiColor
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column(

            ) {
                Text(text = "The Tolet", style = MaterialTheme.typography.headlineMedium)
                Text(text = "Find Your House", style = MaterialTheme.typography.titleMedium)
            }
        }
        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(alignment = Alignment.BottomCenter),
            color = uiColor
        )
    }
}