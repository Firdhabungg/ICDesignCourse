package com.example.icdesigncourse

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.RecyclerView

class Paket_course : AppCompatActivity() {
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTrx = fragmentManager.beginTransaction()
        fragmentTrx.replace(R.id.fragmentContainerView, fragment)
        fragmentTrx.commit()
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_paket_course)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtMenuModul:TextView = findViewById(R.id.txtMenuModul)
        val txtMenuPembelian:TextView = findViewById(R.id.txtMenuPembelian)
        val txtMenuAkun:TextView = findViewById(R.id.txtMenuAkun)
        val fragmentContainer:FragmentContainerView = findViewById(R.id.fragmentContainerView)

        txtMenuPembelian.setOnClickListener{
            replaceFragment(PaketFragment())
        }

        txtMenuModul.setOnClickListener{
            replaceFragment(Modul())
        }

        txtMenuAkun.setOnClickListener{
            replaceFragment(MenuAkun())
        }

        val txtBeginner = findViewById<TextView>(R.id.beginnerButton)
        txtBeginner.setOnClickListener {
            val intentBeginner = Intent(this@Paket_course, DetailPaketBeginner::class.java)
            startActivity(intentBeginner)
        }

        val txtIntermediate = findViewById<TextView>(R.id.intermediateButton)
        txtIntermediate.setOnClickListener {
            val intentIntermediate = Intent(this@Paket_course, DetailPaketIntermediate::class.java)
            startActivity(intentIntermediate)
        }

        val txtHighLevel = findViewById<TextView>(R.id.highLevelButton)
        txtHighLevel.setOnClickListener {
            val intentHighLevel = Intent(this@Paket_course, DetailPaketHigh::class.java)
            startActivity(intentHighLevel)
        }
    }
}