package com.example.treinamentotestes

import android.app.Activity
import android.app.Instrumentation
import androidx.annotation.StringRes
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers

class loginArrange(action: loginArrange.() -> Unit) {
    init {
        action.invoke(this)
    }

    fun mockHomeActivityIntent() {
        Intents.intending(IntentMatchers.hasComponent(HomeActivity::class.java.name))
            .respondWith(Instrumentation.ActivityResult(Activity.RESULT_CANCELED, null))
    }
}

class loginAct(action: loginAct.() -> Unit) {
    init {
        action.invoke(this)
    }

    fun typeUsername(username: String) {
        Espresso.onView(ViewMatchers.withId(R.id.username))
            .perform(ViewActions.typeText(username))
    }

    fun typePassword(password: String) {
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .perform(ViewActions.typeText(password))
    }

    fun clickLogin() {
        Espresso.onView(ViewMatchers.withId(R.id.login))
            .perform(ViewActions.click())
    }
}

class loginAssert(action: loginAssert.() -> Unit) {
    init {
        action.invoke(this)
    }

    fun checkUsernameIsEmpty() {
        Espresso.onView(ViewMatchers.withId(R.id.username))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    fun checkPasswordIsEmpty() {
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    fun checkMessageWasShown(@StringRes messageRes: Int) {
        Espresso.onView(ViewMatchers.withText(messageRes))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun checkHomeActivityWasCalled() {
        Intents.intended(IntentMatchers.hasComponent(HomeActivity::class.java.name))
    }
}
