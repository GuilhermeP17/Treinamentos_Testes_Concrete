package com.example.treinamentotestes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import com.example.treinamentotestes.utils.PasswordValidator
import com.example.treinamentotestes.utils.UsernameValidator
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels {
        LoginViewModelFactory(UsernameValidator(), PasswordValidator())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel.getViewState().observe(this, Observer {
            when (it) {
                is LoginViewModelState.Error -> showErrorMessage(it.message)
                is LoginViewModelState.NavigateToHome -> navigateToHome()
            }
        })

        login.setOnClickListener() {
            loginViewModel.validateLogin(
                username.text.toString(),
                password.text.toString()
            )
        }
    }

    private fun showErrorMessage(@StringRes errorMessage: Int) {
        AlertDialog.Builder(this)
            .setMessage(errorMessage)
            .show()
    }

    private fun navigateToHome() {
        startActivity(Intent(applicationContext, HomeActivity::class.java))
    }
}