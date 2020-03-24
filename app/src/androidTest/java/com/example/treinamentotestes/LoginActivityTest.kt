package com.example.treinamentotestes

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun givenInitialState_ShouldHaveEmptyUsernameAndPassword() {
        onView(withId(R.id.username))
            .check(matches(withText("")))
        onView(withId(R.id.password))
            .check(matches(withText("")))
    }

    @Test
    fun givenUsernameIsEmpty_whenLogin_shouldShowEmptyUsernameError() {
        onView(withId(R.id.password))
            .perform(typeText("abCD@3223233"))
        onView(withId(R.id.login))
            .perform(click())

        onView(withText(R.string.empty_username_error))
            .check(matches(isDisplayed()))
    }
}