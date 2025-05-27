package com.praroop.login.presention.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.praroop.simpleloginui.ui.theme.orange
import com.praroop.simpleloginui.ui.theme.white

@Composable
fun TextEntryModule(
    description:String,
    hint:String,
    leadingIcon:ImageVector,
    textValue:String,
    keyBoardType:KeyboardType=KeyboardType.Ascii,
    visualTransformation:VisualTransformation=VisualTransformation.None,
    textColor:Color,
    cursorColor:Color,
    onValueChanged:(String)->Unit,
    trailingIcon:ImageVector?=null,
    onTrailingIconClick:(()->Unit)?,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            description,
            color = textColor,
            style = MaterialTheme.typography.bodyLarge,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 3.dp)
                .border(0.5.dp, textColor, RoundedCornerShape(25.dp)),
            value = textValue,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = white,
                cursorColor = cursorColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent

            ),
            onValueChange = onValueChanged,
            shape = RoundedCornerShape(25.dp),
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null,
                    tint = cursorColor
                )
            },
            trailingIcon = {
                if (trailingIcon != null) {
                    Icon(
                        imageVector = trailingIcon,
                        contentDescription = null,
                        tint = cursorColor,
                        modifier = Modifier.clickable {
                            if (onTrailingIconClick!=null) onTrailingIconClick()
                        }
                    )
                    
                }
            },
            placeholder = {
                Text(hint,
                    style = MaterialTheme.typography.bodyLarge)
            },
            textStyle = MaterialTheme.typography.bodyLarge,
            keyboardOptions = KeyboardOptions(keyboardType = keyBoardType),
            visualTransformation = visualTransformation
        )
    }
    
}

@Preview(showBackground = true)
@Composable
fun textEntryPreview(){
    TextEntryModule(
        description = "Email address",
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp,0.dp,10.dp,5.dp),
        hint = "KApps@gmail.com",
        leadingIcon = Icons.Default.Email,
        textValue = "",
        textColor = Color.Black,
        cursorColor = orange,
        onValueChanged = {},
        trailingIcon = Icons.Filled.Clear,
        onTrailingIconClick = {},
//        visualTransformation = PasswordVisualTransformation()
    )
}