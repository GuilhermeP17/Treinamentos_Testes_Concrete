package com.example.treinamentotestes

import com.example.treinamentotestes.utils.PasswordValidator
import junit.framework.Assert.assertFalse
import org.junit.Test

class PasswordValidatorTest{

    @Test
    fun givenPassworIsEmpty_whenValidate_shouldReturnFalse(){
        val result = PasswordValidator().isValid("")
        assertFalse(result)
    }

    @Test
    fun givenPasswordIsShorterThan8_whenValidate_shouldReturnFalse(){
        val result = PasswordValidator().isValid("concret")
        assertFalse(result)
    }

    @Test
    fun givenPasswordDontContainsUpCase_whenValidate_shouldReturnFalse(){
        val result = PasswordValidator().isValid("concrete@123")
        assertFalse(result)
    }

    @Test
    fun givenPasswordDontContainsLowerCase_whenValidate_shouldReturnFalse(){
        val result = PasswordValidator().isValid("CONCRETE@123")
        assertFalse(result)
    }

    @Test
    fun givenPasswordDontContainsNumber_whenValidate_shouldReturnFalse(){
        val result = PasswordValidator().isValid("Concrete@")
        assertFalse(result)
    }

    @Test
    fun givenPasswordDontContainsSpecialCharacter_whenValidate_shouldReturnFalse(){
        val result = PasswordValidator().isValid("Concrete123")
        assertFalse(result)
    }

    @Test
    fun givenPasswordContainsAllRequiredCharactes_whenValidated_shouldReturnTrue(){
        val result = PasswordValidator().isValid("Concrete@123")
        assert(result)
    }
}