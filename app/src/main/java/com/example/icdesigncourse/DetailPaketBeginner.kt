package com.example.icdesigncourse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailPaketBeginner : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_paket_beginner)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.DetailPaketBeginner1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnBack = findViewById<ImageView>(R.id.btnBackBeginner)
        btnBack.setOnClickListener {
            val intentBack = Intent(this, Home_activity::class.java)
            startActivity(intentBack)
        }
        val btnBuyPaket = findViewById<Button>(R.id.btn_buyPaket)
        btnBuyPaket.setOnClickListener {
            val intenBuyPaket = Intent(this, MetodePembayaran::class.java)
            startActivity(intenBuyPaket)
        }
    }
}