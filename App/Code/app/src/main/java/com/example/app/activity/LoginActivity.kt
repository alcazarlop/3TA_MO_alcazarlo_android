package com.example.app.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.app.R
import com.google.firebase.FirebaseApp

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        FirebaseApp.initializeApp(this)

        val username = findViewById<EditText>(R.id.user)
        val password = findViewById<EditText>(R.id.pass)
        val button = findViewById<Button>(R.id.loginButton)

        button.setOnClickListener {
            if(username.text.toString() == "wllop" && password.text.toString() == "a123456*"){
                val intent = Intent(this, MainActivity::class.java)
                this.startActivity(intent)
            }
            else {
                Toast.makeText(this, "Wrong User or Password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}