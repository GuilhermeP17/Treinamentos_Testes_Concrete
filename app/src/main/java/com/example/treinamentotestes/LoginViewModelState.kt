package com.example.treinamentotestes

sealed class LoginViewModelState {
    data class Error(val message: Int) : LoginViewModelState()
    object NavigateToHome : LoginViewModelState()
}
