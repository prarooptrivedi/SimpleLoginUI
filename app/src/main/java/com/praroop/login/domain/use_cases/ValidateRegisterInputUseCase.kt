package com.praroop.login.domain.use_cases

import com.praroop.login.domain.model.RegisterInputValidationType
import com.praroop.login.util.containsNumber
import com.praroop.login.util.containsSpecialChar
import com.praroop.login.util.containsUpperCase

class ValidateRegisterInputUseCase {

    operator fun invoke(email:String,password:String,passwordRepeated:String):RegisterInputValidationType{
        if (email.isEmpty() || password.isEmpty() || passwordRepeated.isEmpty()){
            return RegisterInputValidationType.EmptyFiled
        }
        if ("@" !in email){
            return RegisterInputValidationType.NoEmail
        }
        if (password!=passwordRepeated){
            return RegisterInputValidationType.PasswordsDoNotMatch
        }
        if (password.count()<8){
            return RegisterInputValidationType.PasswordTooShort
        }
        if (!password.containsNumber()){
            return  RegisterInputValidationType.PasswordNumberMissing

        }
        if (!password.containsUpperCase()){
            return  RegisterInputValidationType.PasswordUpperCaseMissing

        }
        if (!password.containsSpecialChar()){
            return  RegisterInputValidationType.PasswordSpecialCharMissing

        }

        return RegisterInputValidationType.Valid

    }
}