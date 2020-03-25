package com.example.treinamentotestes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import com.example.treinamentotestes.utils.PasswordValidator
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.setOnClickListener() {
            if (validateFields(username.text.toString(), password.text.toString())) {
                startActivity(Intent(applicationContext, HomeActivity::class.java))
            }
        }
    }

    private fun showErrorMessage(@StringRes errorMessage: Int) {
        AlertDialog.Builder(this)
            .setMessage(errorMessage)
            .show()
    }

    private fun validateFields(username: String, password: String): Boolean {
        val errorMessage = when {
            username.isEmpty() -> R.string.empty_username_error
            password.isEmpty() -> R.string.empty_password_error
            !PasswordValidator().isValid(password) -> R.string.invalid_password_error
            else -> return true
        }

        showErrorMessage(errorMessage)
        return false
    }

}