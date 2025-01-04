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
import com.example.icdesigncourse.client.RetrofitClient
import com.example.icdesigncourse.response.modul.ModulResponse
import com.squareup.picasso.Picasso

class AdapterModul (private val listModul: ArrayList<ModulResponse>) :
    RecyclerView.Adapter<AdapterModul.ModulViewHolder>() {

    inner class ModulViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idModul: TextView = itemView.findViewById(R.id.textidModul)
        val cardModul: CardView = itemView.findViewById(R.id.cardModul)
        val imageModul: ImageView = itemView.findViewById(R.id.imageModul1)
        val textModul: TextView = itemView.findViewById(R.id.textModul)
        val context: Context? = itemView.context

        fun bind(response: ModulResponse) {
            val idModul:String = "${response.id_modul}"
            val namaModul = "${response.nama_modul}"
            val picture = "${response.gambar_modul}"


            textModul.text = namaModul
            val url = RetrofitClient.url + picture
            Picasso.get().load(url).into(imageModul)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModulViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout_modul, parent, false)
        return ModulViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModulViewHolder, position: Int) {
        val modul = listModul[position]

        holder.apply {
            bind(modul) // Gunakan metode bind yang sudah dibuat
            cardModul.setOnClickListener {
                // Tambahkan aksi yang diinginkan saat card diklik
                Log.d("AdapterModul", "Clicked on Modul: ${modul.nama_modul}")
            }
        }
    }

    override fun getItemCount(): Int = listModul.size
}
