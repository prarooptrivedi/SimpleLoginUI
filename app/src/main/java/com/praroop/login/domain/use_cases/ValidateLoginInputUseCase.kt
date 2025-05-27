package com.praroop.login.domain.use_cases

import android.provider.ContactsContract.CommonDataKinds.Email
import com.praroop.login.domain.model.LoginInputValidationType

class ValidateLoginInputUseCase {
    operator  fun invoke(email: String,password:String):LoginInputValidationType{
        if (email.isEmpty() ||password.isEmpty()){
            return LoginInputValidationType.EmptyFiled
        }
        if ("@" !in email){
            return LoginInputValidationType.NoEmail
        }
        return LoginInputValidationType.Valid

    }
}