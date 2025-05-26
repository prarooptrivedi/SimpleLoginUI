package com.praroop.simpleloginui.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)
val Black = Color(0xFF000113)
val LightBlueWhite = Color(0xFFF1F5F9) //Social media background
val BlueGray = Color(0xFF334155)
val ColorScheme.focusedTextFieldText
@Composable
get() = if (isSystemInDarkTheme()) Color.White else Color.Black

val ColorScheme.unfocusedTextFieldText
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF94A388) else Color(0xFF475569)

val ColorScheme.textFieldContainer
    @Composable
    get() = if (isSystemInDarkTheme()) BlueGray.copy(alpha = 0.6f) else LightBlueWhite

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)



val darkGray = Color(0xFF1a1717)
val darkBlue = Color(0xFF18192b)
val white = Color(0xFFF3F3F3)
val gray = Color(0xFF3F3F3F)
val orange = Color(0xFFdb660d)
val whiteGrayOrange = Color(0xFF7a5c4c)
val nightDark = Color(0xFF403757)

val purple = Color(0xFF9b11ba)

val redOrange = Color(0xFFe84a23)
val green = Color(0xFF0ddb25)
val blue = Color(0xFF140ddb)
val brightBlue = Color(0xFF027cf5)