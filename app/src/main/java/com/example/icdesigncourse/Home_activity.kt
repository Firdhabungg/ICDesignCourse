package com.example.icdesigncourse

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class Home_activity : AppCompatActivity() {
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTrx = fragmentManager.beginTransaction()
        fragmentTrx.replace(R.id.fragmentContainerView, fragment)
        fragmentTrx.commit()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home_activity)

        val txtMenuModul:TextView = findViewById(R.id.txtMenuModul)
        val txtMenuPembelian:TextView = findViewById(R.id.txtMenuPembelian)
        val txtMenuAkun:TextView = findViewById(R.id.txtMenuAkun)
        val fragmentContainer:FragmentContainerView = findViewById(R.id.fragmentContainerView)

        txtMenuModul.setOnClickListener{
            replaceFragment(ModulFragment())
        }
        txtMenuPembelian.setOnClickListener{
            replaceFragment(PaketFragment())
        }

        txtMenuAkun.setOnClickListener{
            replaceFragment(MenuAkun())
        }

//        val txtBeginner = findViewById<TextView>(R.id.beginneerButton)
//        txtBeginner.setOnClickListener {
//            val intentBeginner = Intent(this@Home_activity, DetailPaketBeginner::class.java)
//            startActivity(intentBeginner)
//        }
//
//        val txtIntermediate = findViewById<TextView>(R.id.intermediateButton)
//        txtIntermediate.setOnClickListener {
//            val intentIntermediate = Intent(this@Home_activity, DetailPaketIntermediate::class.java)
//            startActivity(intentIntermediate)
//        }
//
//        val txtHighLevel = findViewById<TextView>(R.id.highLevelButton)
//        txtHighLevel.setOnClickListener {
//            val intentHighLevel = Intent(this@Home_activity, DetailPaketHigh::class.java)
//            startActivity(intentHighLevel)
//        }
    }
}