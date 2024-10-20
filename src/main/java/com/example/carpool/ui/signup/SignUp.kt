package com.example.carpool.ui.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.carpool.R
import com.example.carpool.ui.home.Home
import com.example.carpool.ui.login.login
import com.google.android.material.textfield.TextInputLayout

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onRegisterButtonClick(view: View) {
        if (
            findViewById<TextInputLayout>(R.id.inputEmail).editText?.text.toString().trim().isEmpty()
            || findViewById<TextInputLayout>(R.id.inputPhoneNumber).editText?.text.toString().trim().isEmpty()
            || findViewById<TextInputLayout>(R.id.inputName).editText?.text.toString().trim().isEmpty()
            || findViewById<TextInputLayout>(R.id.inputPassword).editText?.text.toString().trim().isEmpty()
        ) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(this, "Register Success!", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, Home::class.java)

        intent.putExtra("name", findViewById<TextInputLayout>(R.id.inputName).editText?.text.toString().trim())
        intent.putExtra("phoneNumber", findViewById<TextInputLayout>(R.id.inputPhoneNumber).editText?.text.toString().trim())

        startActivity(intent)
    }

    fun onLoginButtonClick(view: View) {
        Toast.makeText(this, "Going to login page", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, login::class.java)
        startActivity(intent)
    }
}
