package com.example.icdesigncourse

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

//class AdapterModul(private val modulList: ArrayList<ModulModel>) :
//    RecyclerView.Adapter<AdapterModul.ViewHolder>() {
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val imgModul: ImageView = itemView.findViewById(R.id.imageModul1)
//        val tvNamaModul: TextView = itemView.findViewById(R.id.textModul)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.card_layout_modul, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val modul = modulList[position]
//        holder.imgModul.setImageResource(modul.gambar)
//        holder.tvNamaModul.text = modul.namaModul
//
//        Log.d("AdapterModul", "Binding item: ${modul.namaModul}")
//    }
//
//    override fun getItemCount(): Int {
//        return modulList.size
//    }
//}
class AdapterModul(private val listModul: ArrayList<ModulModel>) :
    RecyclerView.Adapter<AdapterModul.ModulViewHolder>() {

    inner class ModulViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardModul: CardView = itemView.findViewById(R.id.cardModul)
        val imageModul: ImageView = itemView.findViewById(R.id.imageModul1)
        val textModul: TextView = itemView.findViewById(R.id.textModul)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModulViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout_modul, parent, false)
        return ModulViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModulViewHolder, position: Int) {
        val modul = listModul[position]

        holder.apply {
            imageModul.setImageResource(modul.gambar)
            textModul.text = modul.namaModul

            // Optional: Jika ingin menambahkan onClick listener
            cardModul.setOnClickListener {
                // Tambahkan aksi yang diinginkan saat card diklik
            }
        }
    }

    override fun getItemCount(): Int = listModul.size
}
