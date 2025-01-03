package com.example.icdesigncourse

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ModulFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ModulFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_modul, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val RVModul: RecyclerView = view.findViewById(R.id.recycleViewModul)
        RVModul.layoutManager = GridLayoutManager(activity,2)

        val modul = ArrayList<ModulModel>()
        modul.add(ModulModel(R.drawable.konsepuiux,"Konsep Dasar UI/UX"))
        modul.add(ModulModel(R.drawable.research,"Research"))
        modul.add(ModulModel(R.drawable.wireframing,"Wireframing"))
        modul.add(ModulModel(R.drawable.userflow,"User flow"))
        modul.forEach { Log.d("ModulFragment", "Modul: ${it.namaModul}") }

        val adapterModul = AdapterModul(modul)
        RVModul.adapter = adapterModul
        Log.d("AdapterModul", "Data size: ${modul.size}")

    }

}