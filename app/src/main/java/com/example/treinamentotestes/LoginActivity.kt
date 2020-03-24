package com.example.treinamentotestes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.treinamentotestes.utils.PasswordValidator

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username: TextView = findViewById(R.id.username)
        val password: TextView = findViewById(R.id.password)
        val btnLogin: Button = findViewById(R.id.login)

        btnLogin.setOnClickListener(){
            if (validateFields(username.text.toString(), password.text.toString())) {
                startActivity(Intent(applicationContext, HomeActivity::class.java))
            }
        }

    }

    private fun showErrorMessage(message: String) {
        val alertDialogBuilder = AlertDialog.Builder(this)
        val alertDialog: AlertDialog

        alertDialogBuilder.setMessage(message)
        alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun validateFields(username: String, password: String): Boolean {
        val errorMessage: String

        if (username.isEmpty())
            errorMessage = getString(R.string.empty_username_error)
        else if (password.isEmpty())
            errorMessage = getString(R.string.empty_password_error)
        else if (!PasswordValidator().isValid(password))
            errorMessage = getString(R.string.invalid_password_error)
        else
            return true

        showErrorMessage(errorMessage)
        return false
    }

}