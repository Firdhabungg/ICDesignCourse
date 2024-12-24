package com.example.icdesigncourse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuRegister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtEmail:EditText = findViewById(R.id.editEmailR)
        val txtNamaLengkap:EditText = findViewById(R.id.editNamaR)
        val txtSandi:EditText = findViewById(R.id.editSandiR)
        val btnDaftar = findViewById<Button>(R.id.buttonDaftar)
        btnDaftar.setOnClickListener {
            if(txtEmail.text.isNotEmpty() && txtNamaLengkap.text.isNotEmpty() && txtSandi.text.isNotEmpty())  {
                val register = Intent(this, MenuLogin::class.java)
                Toast.makeText(this, "Registrasi Akun berhasil", Toast.LENGTH_SHORT).show()
                startActivity(register)
            }else {
                Toast.makeText(this, "Lengkapi registrasi anda", Toast.LENGTH_SHORT).show()
            }
        }
    }
}