package com.example.icdesigncourse

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class PaketFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_paket, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtBeginner = view.findViewById<TextView>(R.id.beginnerButton)
        val txtIntermediate = view.findViewById<TextView>(R.id.intermediateButton)
        val txtHighLevel = view.findViewById<TextView>(R.id.highLevelButton)

        txtBeginner.setOnClickListener {
            val intentBeginner = Intent(requireContext(), DetailPaketBeginner::class.java)
            startActivity(intentBeginner)
        }

        txtIntermediate.setOnClickListener {
            val intentIntermediate = Intent(requireContext(), DetailPaketIntermediate::class.java)
            startActivity(intentIntermediate)
        }

        txtHighLevel.setOnClickListener {
            val intentHighLevel = Intent(requireContext(), DetailPaketHigh::class.java)
            startActivity(intentHighLevel)
        }
    }
}
