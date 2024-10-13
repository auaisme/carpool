package com.example.carpool.ui.login

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
import com.example.carpool.ui.signup.SignUp
import com.google.android.material.textfield.TextInputLayout

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onRegisterButtonClick(view: View) {
        Toast.makeText(this, "Going to register page", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, SignUp::class.java)
        startActivity(intent)
    }

    fun onLoginButtonClick(view: View) {
        if (
            findViewById<TextInputLayout>(R.id.inputEmail).editText?.text.toString().trim().isEmpty()
            || findViewById<TextInputLayout>(R.id.inputPassword).editText?.text.toString().trim().isEmpty()
        ) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, Home::class.java)

        intent.putExtra("name", "Get from Server")
        intent.putExtra("phoneNumber", "Get from Server")

        startActivity(intent)
    }
}