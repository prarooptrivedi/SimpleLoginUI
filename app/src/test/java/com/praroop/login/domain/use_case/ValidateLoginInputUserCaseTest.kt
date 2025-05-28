package com.praroop.login.domain.use_case

import com.praroop.login.domain.use_cases.ValidateLoginInputUseCase
import com.google.common.truth.Truth.assertThat
import com.praroop.login.domain.model.LoginInputValidationType
import org.junit.Test

class ValidateLoginInputUserCaseTest {
private val validateLoginInputUseCase=ValidateLoginInputUseCase()

    @Test
    fun `test empty email field return Validation type empty field`(){
        val result=validateLoginInputUseCase(email = "", password = "password")
        assertThat(result).isEqualTo(LoginInputValidationType.EmptyFiled)
    }

    @Test
    fun `test empty password field return Validation type empty field`(){
        val result=validateLoginInputUseCase(email = "praroop@gmail.com", password = "")
        assertThat(result).isEqualTo(LoginInputValidationType.EmptyFiled)
    }

    @Test
    fun `test no email  return Validation type  no email`(){
        val result=validateLoginInputUseCase(email = "praroopgmail.com", password = "password")
        assertThat(result).isEqualTo(LoginInputValidationType.NoEmail)
    }

    @Test
    fun `test everything is coorect return validation type valid`(){
        val result=validateLoginInputUseCase(email = "praroop@gmail.com", password = "password")
        assertThat(result).isEqualTo(LoginInputValidationType.Valid)
    }
}