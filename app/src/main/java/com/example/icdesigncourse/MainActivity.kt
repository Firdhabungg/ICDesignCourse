package com.example.icdesigncourse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnMasuk = findViewById<Button>(R.id.btnMasuk)
        btnMasuk.setOnClickListener {
//            Button login diklik maka akan ke menu login
            val intentLogin = Intent(this, MenuLogin::class.java)
            startActivity(intentLogin)
        }
        val btnDaftar = findViewById<Button>(R.id.btnDaftar)
        btnDaftar.setOnClickListener {
            val intentRegis = Intent(this, MenuRegister::class.java)
            startActivity(intentRegis)
        }
    }
}