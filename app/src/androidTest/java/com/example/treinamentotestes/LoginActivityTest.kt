package com.example.treinamentotestes

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    val activityRule = IntentsTestRule(LoginActivity::class.java)

    @Test
    fun givenInitialState_ShouldHaveEmptyUsernameAndPassword() {
        loginAssert {
            checkUsernameIsEmpty()
            checkPasswordIsEmpty()
        }
    }

    @Test
    fun givenUsernameIsEmpty_whenLogin_shouldShowEmptyUsernameError() {
        loginAct {
            typePassword("abCD@3223233")
            clickLogin()
        }

        loginAssert {
            checkMessageWasShown(R.string.empty_username_error)
        }
    }

    @Test
    fun givenPasswordIsEmpty_whenLogin_shouldShowEmptyPasswordError() {
        loginAct {
            typeUsername("Guilherme")
            clickLogin()
        }

        loginAssert {
            checkMessageWasShown(R.string.empty_password_error)
        }
    }

    @Test
    fun giverPasswordIsInvalid_whenLogin_shouldShowInvalidPasswordError() {
        loginAct{
            typeUsername("Guilherme")
            typePassword("Concrete123")
            clickLogin()
        }

        loginAssert{
            checkMessageWasShown(R.string.invalid_password_error)
        }
    }

    @Test
    fun givenPasswordIsValid_whenLogin_shouldRedirectToHomeActivity() {
        loginArrange{
            mockHomeActivityIntent()
        }

        loginAct {
            typeUsername("Guilherme")
            typePassword("Concrete@123")
            clickLogin()
        }

        loginAssert{
            checkHomeActivityWasCalled()
        }
    }
}