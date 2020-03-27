package com.example.treinamentotestes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.treinamentotestes.utils.PasswordValidator
import com.example.treinamentotestes.utils.UsernameValidator

class LoginViewModel(
    private val usernameValidator: UsernameValidator,
    private val passwordValidator: PasswordValidator
) : ViewModel() {

    private val state = MutableLiveData<LoginViewModelState>()

    fun getViewState(): LiveData<LoginViewModelState> = state

    fun validateLogin(username: String, password: String) {
        val isUsernameValid = usernameValidator.isValid(username)
        val isPasswordValid = passwordValidator.isValid(password)

        state.value = if (isUsernameValid && isPasswordValid){
            LoginViewModelState.NavigateToHome
        } else {
            LoginViewModelState.Error(R.string.generic_login_error)
        }
    }

}
