package com.example.icdesigncourse

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterModul (private val listModul:List<ModulModel>):
RecyclerView.Adapter<AdapterModul.ViewHolder>(){
    inner class ViewHolder(v: View):RecyclerView.ViewHolder(v) {
        val imgFotoModul: ImageView
        val textNamaModul: TextView
        val context = v.context;

        init {
            imgFotoModul = v.findViewById(R.id.imageModul1)
            textNamaModul = v.findViewById(R.id.textModul)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterModul.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(
            R.layout.card_layout_modul,
            parent, false)

        return AdapterModul.ViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: AdapterModul.ViewHolder, position: Int) {
        val modulModel = listModul[position]
        holder.imgFotoModul.setImageResource(modulModel.gambar)
        holder.textNamaModul.text = modulModel.namaModul
    }

    override fun getItemCount(): Int {
        return listModul.size
    }

}