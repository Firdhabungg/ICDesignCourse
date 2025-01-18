package com.example.icdesigncourse

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.icdesigncourse.client.RetrofitClient
import com.example.icdesigncourse.response.modul.ModulResponse
import com.squareup.picasso.Picasso

class AdapterDetailModul (private val listModul: ArrayList<ModulResponse>) :
    RecyclerView.Adapter<AdapterDetailModul.ModulViewHolder>() {
    inner class ModulViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idModul: TextView = itemView.findViewById(R.id.textidModul)
        val imageModul: ImageView = itemView.findViewById(R.id.imageModul1)
        val namaModul: TextView = itemView.findViewById(R.id.namaModul)
        val deskripsi: TextView = itemView.findViewById(R.id.deskripsiDetailModul)
        val context: Context? = itemView.context

        fun bind(response: ModulResponse) {
            val idModul:String = "${response.id_modul}"
            val namaModul = "${response.nama_modul}"
            val picture = "${response.gambar_modul}"


//            namaModul.text = namaModul
            val url = RetrofitClient.url + picture
            Picasso.get().load(url).into(imageModul)
        }

    }
}