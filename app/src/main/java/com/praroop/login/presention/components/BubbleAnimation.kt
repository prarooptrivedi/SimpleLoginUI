package com.praroop.login.presention.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.praroop.simpleloginui.ui.theme.gray
import com.praroop.simpleloginui.ui.theme.orange

@Composable
fun BubbleAnimation(
    modifier: Modifier = Modifier,
    bubbleColor1:Color,
    bubbleColor2: Color
) {
    val infiniteTransistion= rememberInfiniteTransition()

    Box(
        modifier=modifier
    ){
        val xValue by infiniteTransistion.animateFloat(
            initialValue = 100f,
            targetValue = 134f,
            animationSpec = infiniteRepeatable(
                animation = tween(7000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )

        val yValue by infiniteTransistion.animateFloat(
            initialValue = 100f,
            targetValue = 700f,
            animationSpec = infiniteRepeatable(
                animation = tween(6000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )

        val xValue2 by infiniteTransistion.animateFloat(
            initialValue = 1340f,
            targetValue = 100f,
            animationSpec = infiniteRepeatable(
                animation = tween(8000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        val yValue2 by infiniteTransistion.animateFloat(
            initialValue = 400f,
            targetValue = 200f,
            animationSpec = infiniteRepeatable(
                animation = tween(7000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        val xValue3 by infiniteTransistion.animateFloat(
            initialValue = 1000f,
            targetValue = 400f,
            animationSpec = infiniteRepeatable(
                animation = tween(7500, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        val yValue3 by infiniteTransistion.animateFloat(
            initialValue = 150f,
            targetValue = 600f,
            animationSpec = infiniteRepeatable(
                animation = tween(6000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        Canvas(
            modifier=Modifier.fillMaxSize()
        ){
            drawCircle(
                brush = Brush.linearGradient(
                    listOf(bubbleColor1,bubbleColor2),
                    start = Offset(xValue-99,yValue),
                    end = Offset(xValue+90,yValue)

                ),
                radius = 100f,
                center=Offset(xValue,yValue)
            )
            drawCircle(
                brush = Brush.linearGradient(
                    listOf(bubbleColor1,bubbleColor2),
                    start = Offset(xValue2-99,yValue2),
                    end = Offset(xValue2+90,yValue2)

                ),
                radius = 100f,
                center=Offset(xValue2,yValue)
            )
            drawCircle(
                brush = Brush.linearGradient(
                    listOf(bubbleColor1,bubbleColor2),
                    start = Offset(xValue3-99,yValue3),
                    end = Offset(xValue3+90,yValue3)

                ),
                radius = 70f,
                center=Offset(xValue3,yValue3)
            )

        }
    }
    
}

@Preview(showBackground = true)
@Composable
fun BubbleAnimationPreview(){
    BubbleAnimation(
        bubbleColor1 = orange,
        bubbleColor2 = gray,
        modifier = Modifier.fillMaxWidth()
            .height(250.dp)
    )
}