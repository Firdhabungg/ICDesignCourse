package com.example.icdesigncourse

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.icdesigncourse.client.RetrofitClient
import com.example.icdesigncourse.response.modul.ModulResponse
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Detail_Modul : AppCompatActivity() {
    private lateinit var txtJudulModul: TextView
    private lateinit var imgModul: ImageView
    private lateinit var txtDeskripsiModul: TextView
    private lateinit var txtMateri: TextView
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_modul)

        // Initialize views
        initViews()

        // Set up back button
        setupBackButton()

        // Get data from intent and display
        displayModulData()
    }

    private fun initViews() {
        txtJudulModul = findViewById(R.id.judulModul)
        imgModul = findViewById(R.id.imageModulDetail)
        txtDeskripsiModul = findViewById(R.id.DeskripsiModul)
        txtMateri = findViewById(R.id.Materi)
        backButton = findViewById(R.id.backButton) // Add id to ImageView in layout
    }

    private fun setupBackButton() {
        backButton.setOnClickListener {
            finish()
        }
    }

    private fun displayModulData() {
        try {
            val idModul = intent.getStringExtra("idModul") ?: return
            val namaModul = intent.getStringExtra("namaModul") ?: ""
            val picture = intent.getStringExtra("picture") ?: ""
            val deskripsi = intent.getStringExtra("deskripsi") ?: ""
            val materi = intent.getStringExtra("materi") ?: ""

            txtJudulModul.text = namaModul
            txtDeskripsiModul.text = deskripsi
            txtMateri.text = materi

            val imageUrl = RetrofitClient.url + picture
            Picasso.get()
                .load(imageUrl)
                .error(R.drawable.grafis) // Fallback image jika gagal load
                .into(imgModul)

        } catch (e: Exception) {
            Toast.makeText(this, "Terjadi kesalahan: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}