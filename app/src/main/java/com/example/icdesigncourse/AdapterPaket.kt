package com.example.icdesigncourse

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.icdesigncourse.response.paket.PaketResponse

class AdapterPaket<ViewGroup>(private val listPaket: ArrayList<PaketResponse>) :
    RecyclerView.Adapter<AdapterPaket<Any?>.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val class_paket: ImageView = v.findViewById(R.id.textClassPaket)
        val harga: TextView = v.findViewById(R.id.textHargaPaket)
        val deskripsi: TextView = v.findViewById(R.id.textDeskripsi)

        fun bind(response: PaketResponse) {
            // Mengisi data dari API ke elemen UI
            val paket  = "${response.kelas_paket}"
            val harga  = "${response.harga}"
//            tambah data response ke TextView dan ImageView
            class_paket.text = paket
            harga.text = harga

            // Tambahkan listener pada tombol detail jika diperlukan
            btnDetailPaket.setOnClickListener {
                println("Detail Paket ${response.paket_name} ditampilkan!")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val view = layoutInflater.inflate(R.layout.card_layout_paket, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listPaket[position])
    }

    override fun getItemCount(): Int {
        return listPaket.size
    }
}