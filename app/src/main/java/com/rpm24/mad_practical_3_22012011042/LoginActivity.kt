package com.rpm24.mad_practical_3_22012011042

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val email = intent.getStringExtra("email").toString()
        val password = intent.getStringExtra("password").toString()
        Log.i("email", email)
        Log.i("password", password)
        val emailip = findViewById<EditText>(R.id.email_input)
        val passwordip = findViewById<EditText>(R.id.password_input)
        val loginbtn = findViewById<Button>(R.id.login_btn)
        loginbtn.setOnClickListener {
            val emailinput = emailip.text.toString()
            val passwordinput = passwordip.text.toString()
            if (!emailinput.isBlank() && !passwordinput.isBlank()) {
                Toast.makeText(this, "email: $email", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "password: $password", Toast.LENGTH_SHORT).show()
            } else {
                if (emailinput.isBlank()) {
                    Toast.makeText(this, "Enter your email", Toast.LENGTH_SHORT).show()
                } else if (passwordinput.isBlank()) {
                    Toast.makeText(this, "Enter your password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}