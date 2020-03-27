package com.example.treinamentotestes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.treinamentotestes.utils.PasswordValidator
import com.example.treinamentotestes.utils.UsernameValidator

class LoginViewModelFactory(
    private val usernameValidator: UsernameValidator,
    private val passwordValidator: PasswordValidator
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(usernameValidator, passwordValidator) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
