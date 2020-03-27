package com.example.treinamentotestes

import com.example.treinamentotestes.utils.UsernameValidator
import org.junit.Assert.assertFalse
import org.junit.Test

class UsernameValidatorTest(){

    @Test
    fun givenUsernameIsEmpty_whenValidate_shouldReturnFalse(){
        val result = UsernameValidator().isValid("")
        assertFalse(result)
    }

    @Test
    fun givenUsernameIsNotEmpty_whenValidate_shouldReturnTrue(){
        val result = UsernameValidator().isValid("Guilherme")
        assert(result)
    }
}