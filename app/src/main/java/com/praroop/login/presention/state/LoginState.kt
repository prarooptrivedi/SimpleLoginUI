package com.praroop.login.presention.state

data class LoginState (
    val emailInput:String="",
    val passwordInpur:String="",
    val isInputValid:Boolean=false,
    val isPasswordShown:Boolean=false,
    val errorMessageInput:String?=null,
    val isLoading:Boolean=false,
    val isSuccessfullyLoggedIn:Boolean=false,
    val errorMessageLoginProcess:String?=null

)