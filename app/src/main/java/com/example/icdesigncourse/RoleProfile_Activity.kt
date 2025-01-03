package com.example.icdesigncourse

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView

class RoleProfile_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_role_profile)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        val txtEmail: TextView = findViewById(R.id.editEmail)
        val txtPassword: TextView = findViewById(R.id.editPassword)

        txtEmail.text = email
        txtPassword.text = password

        val btnNavigate = findViewById<Button>(R.id.simpan)
        btnNavigate.setOnClickListener {
            val intent = Intent(this, Home_activity::class.java)
            startActivity(intent)
        }
    }
}
