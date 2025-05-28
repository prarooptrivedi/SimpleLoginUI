package com.praroop.login.domain.model

enum class RegisterInputValidationType {
    EmptyFiled,
    NoEmail,
    PasswordsDoNotMatch,
    PasswordUpperCaseMissing,
    PasswordSpecialCharMissing,
    PasswordNumberMissing,
    PasswordTooShort,
    Valid
}