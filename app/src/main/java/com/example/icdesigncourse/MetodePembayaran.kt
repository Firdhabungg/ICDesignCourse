package com.example.icdesigncourse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MetodePembayaran : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_metode_pembayaran)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnBack = findViewById<Button>(R.id.btn_konfirmasi)
        btnBack.setOnClickListener {
            showPaymentSuccess()
        }
    }
    private fun showPaymentSuccess() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Pembayaran Berhasil")
        builder.setMessage("Terima kasih, pembayaran Anda telah berhasil diproses.")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss() // Menutup popup saat tombol OK ditekan
            val intentModul = Intent(this@MetodePembayaran, Home_activity::class.java)
            startActivity(intentModul)
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }
}