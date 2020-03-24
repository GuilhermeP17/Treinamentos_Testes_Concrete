package com.example.treinamentotestes.utils

class PasswordValidator {
    private lateinit var password: String

    fun isValid(password: String) : Boolean{
        this.password = password

        if (!passwordLenght())
            return false

        if (!passwordContainsUpCase())
            return false

        if (!passwordContainsLowerCase())
            return false

        if (!passwordContainsNumber())
            return false

        if (!passwordContainsSpecialCharacter())
            return false

        return true
    }

    private fun passwordLenght(): Boolean {
        return password.length >= 8
    }

    private fun passwordContainsUpCase(): Boolean {
        return password.matches(Regex(".*[A-Z].*"))
    }

    private fun passwordContainsLowerCase(): Boolean {
        return password.matches(Regex(".*[a-z].*"))
    }

    private fun passwordContainsNumber(): Boolean {
        return password.matches(Regex(".*[0-9].*"))
    }

    private fun passwordContainsSpecialCharacter(): Boolean{
        return password.matches(Regex(".*[$&+,:;=\\\\?@#|/'<>.^*()%!-].*"))
    }
}
