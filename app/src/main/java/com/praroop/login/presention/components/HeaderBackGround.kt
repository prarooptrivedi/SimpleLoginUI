package com.praroop.login.presention.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.praroop.simpleloginui.ui.theme.orange
import com.praroop.simpleloginui.ui.theme.whiteGrayOrange

@Composable
fun HeaderBackGround(
    topColor:Color,
    buttomColor:Color,
    modifier: Modifier = Modifier
) {
    val colorList =remember {
        listOf(topColor, buttomColor)
    }
    Canvas(
        modifier=modifier
    ) {
        drawCircle(
            radius = size.width,
            center = Offset(center.x,-size.width/1.5f),
            brush = Brush.linearGradient(colors = colorList, end = Offset(center.x+500f,0f))
        )


    }
    
}

@Preview(showBackground = true)
@Composable
fun prevHeaderBackGround(){
    HeaderBackGround(
        topColor = orange,
        buttomColor = whiteGrayOrange,
        modifier = Modifier.fillMaxSize()
    )
}