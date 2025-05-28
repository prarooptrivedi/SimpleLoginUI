package com.praroop.login.presention.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.praroop.login.domain.use_cases.ValidateLoginInputUseCase
import com.praroop.login.domain.use_cases.ValidateRegisterInputUseCase
import com.praroop.login.presention.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validateLoginInputUseCase:ValidateLoginInputUseCase
){
    var loginState by mutableStateOf(LoginState())
}