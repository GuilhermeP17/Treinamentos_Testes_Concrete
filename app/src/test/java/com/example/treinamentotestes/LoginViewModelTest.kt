package com.example.treinamentotestes

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.treinamentotestes.utils.PasswordValidator
import com.example.treinamentotestes.utils.UsernameValidator
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val mockedPasswordValidator = mockk<PasswordValidator>()
    private val mockedUsernameValidator = mockk<UsernameValidator>()
    private val loginViewModel = LoginViewModel(mockedUsernameValidator, mockedPasswordValidator)

    @Test
    fun givenInvalidPassword_whenValidatingPassword_shouldEmitError() {
        every { mockedUsernameValidator.isValid(any()) } returns true
        every { mockedPasswordValidator.isValid(any()) } returns false

        loginViewModel.validateLogin("username", "password")

        assertEquals(
            loginViewModel.getViewState().value,
            LoginViewModelState.Error(R.string.generic_login_error)
        )
    }

    @Test
    fun givenValidPassword_whenValidatingPassword_shouldNavigateToHome() {
        every { mockedUsernameValidator.isValid(any()) } returns true
        every { mockedPasswordValidator.isValid(any()) } returns true

        loginViewModel.validateLogin("username", "password")

        assertEquals(
            loginViewModel.getViewState().value,
            LoginViewModelState.NavigateToHome
        )
    }

    @Test
    fun givenInvalidUsername_whenValidate_shouldShowEmitError(){
        every { mockedUsernameValidator.isValid(any()) } returns false
        every { mockedPasswordValidator.isValid(any()) } returns true

        loginViewModel.validateLogin("username", "password")

        assertEquals(
            loginViewModel.getViewState().value,
            LoginViewModelState.Error(R.string.generic_login_error)
        )
    }

    @Test
    fun givenValidUsername_whenValidate_shouldShowEmitError(){
        every { mockedUsernameValidator.isValid(any()) } returns true
        every { mockedPasswordValidator.isValid(any()) } returns true

        loginViewModel.validateLogin("username", "password")

        assertEquals(
            loginViewModel.getViewState().value,
            LoginViewModelState.NavigateToHome
        )
    }
}
