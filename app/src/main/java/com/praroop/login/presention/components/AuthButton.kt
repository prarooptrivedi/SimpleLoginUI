package com.praroop.login.presention.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.praroop.simpleloginui.ui.theme.orange
import com.praroop.simpleloginui.ui.theme.white

@Composable
fun AuthButton(
    text: String,
    backGroundColor: Color,
    contentColor: Color,
    enabled: Boolean = true,
    onButtonClick: () -> Unit,
    isLoading: Boolean,
    modifier: Modifier = Modifier

) {
    Button(
        modifier = modifier,
        onClick = {
            onButtonClick()
        },
        shape = RoundedCornerShape(25.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backGroundColor,
            contentColor = contentColor,
            disabledBackgroundColor = backGroundColor,
            disabledContentColor = contentColor
        ),
        enabled = enabled
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = contentColor,
                modifier = Modifier.size(20.dp)
            )

        }
        else{
            Text(text, style = MaterialTheme.typography.body1)
        }
    }

}

@Composable
@Preview(showBackground = true)
fun btnPreview(){
    AuthButton(
        text = "Login",
        backGroundColor = orange,
        contentColor = white,
        onButtonClick = {},
        isLoading = true,
        modifier = Modifier.fillMaxWidth()
    )
}
