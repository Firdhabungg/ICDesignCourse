package com.example.icdesigncourse

import android.content.Context
import android.content.Intent
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

class AdapterModul(private var listModul: ArrayList<ModulResponse>) :
    RecyclerView.Adapter<AdapterModul.ModulViewHolder>() {

    inner class ModulViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtIdModul: TextView = itemView.findViewById(R.id.textidModul)
        val textNamaModul: TextView = itemView.findViewById(R.id.textNamaModul)
        val imageModul: ImageView = itemView.findViewById(R.id.imageModul)
        val cardModul: CardView = itemView.findViewById(R.id.cardModul)
        val context: Context? = itemView.context

        fun bind(response: ModulResponse) {
            val idModul = response.id_modul
            val namaModul = response.nama_modul
            val picture = response.gambar_modul
            val deskripsi = response.deskripsi_modul
            val materi = response.materi

            txtIdModul.text = idModul
            textNamaModul.text = namaModul

            val url = RetrofitClient.url + picture
            Picasso.get().load(url).into(imageModul)

            cardModul.setOnClickListener {
                val intentDetailModul = Intent(context, Detail_Modul::class.java).apply {
                    putExtra("idModul", idModul)
                    putExtra("namaModul", namaModul)
                    putExtra("picture", picture)
                    putExtra("deskripsi", deskripsi)
                    putExtra("materi", materi)
                }
                context?.startActivity(intentDetailModul)
            }
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModulViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout_modul, parent, false)
        return ModulViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModulViewHolder, position: Int) {
        holder.bind(listModul[position])
    }

    override fun getItemCount(): Int {
        return listModul.size
    }
}
