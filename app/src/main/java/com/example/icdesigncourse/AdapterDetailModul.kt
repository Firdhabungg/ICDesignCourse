package com.example.icdesigncourse

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.icdesigncourse.AdapterModul.ModulViewHolder
import com.example.icdesigncourse.client.RetrofitClient
import com.example.icdesigncourse.response.modul.ModulResponse
import com.squareup.picasso.Picasso

class AdapterDetailModul (private val listDetailModul: ArrayList<ModulResponse>) :
    RecyclerView.Adapter<AdapterDetailModul.DetailModulViewHolder>() {
    inner class DetailModulViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idModul: TextView = itemView.findViewById(R.id.textidModul)
        val imageModul: ImageView = itemView.findViewById(R.id.imageModul1)
        val cardDetailModul: CardView = itemView.findViewById(R.id.cardDetailModul)
        val namaModul: TextView = itemView.findViewById(R.id.namaModul)
        val deskripsi: TextView = itemView.findViewById(R.id.deskripsiDetailModul)
        val context: Context? = itemView.context

        fun bind(response: ModulResponse) {
            val idModul:String = "${response.id_modul}"
            val namaModul = "${response.nama_modul}"
            val picture = "${response.gambar_modul}"
            val deskripsi = "${response.deskripsi_modul}"
            val materi = "${response.materi}"


//            namaModul.text = namaModul
            val url = RetrofitClient.url + picture
            Picasso.get().load(url).into(imageModul)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailModulViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout_detail_modul, parent, false)
        return DetailModulViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailModulViewHolder, position: Int) {
        val modul = listDetailModul[position]

        holder.apply {
            bind(modul) // Gunakan metode bind yang sudah dibuat
            cardDetailModul.setOnClickListener {
                // Tambahkan aksi yang diinginkan saat card diklik
                Log.d("AdapterModul", "Clicked on Modul: ${modul.nama_modul}")
            }
        }
    }

    override fun getItemCount(): Int = listDetailModul.size

}