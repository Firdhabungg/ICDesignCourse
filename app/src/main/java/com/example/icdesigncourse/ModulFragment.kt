package com.example.icdesigncourse

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.icdesigncourse.client.RetrofitClient
import com.example.icdesigncourse.response.modul.ModulResponse
import okhttp3.Response
import retrofit2.Call
import retrofit2.Callback

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
    private var param1: String? = null
    private var param2: String? = null
    private val listModul = ArrayList<ModulResponse>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_modul, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//      tambah data ke recylerview
        val RVModul: RecyclerView = view.findViewById(R.id.recycleViewModul)
        RVModul.layoutManager = GridLayoutManager(activity, 2)

        RetrofitClient.instance.getModul().enqueue(object : Callback<ArrayList<ModulResponse>> {
            override fun onResponse(
                call: Call<ArrayList<ModulResponse>>,
                response: retrofit2.Response<ArrayList<ModulResponse>>
            ) {
                listModul.clear()
                response.body()?.let { listModul.addAll(it) }

                var adapterModul = AdapterModul(listModul)
                RVModul.adapter = adapterModul
            }

            override fun onFailure(call: Call<ArrayList<ModulResponse>>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                Log.e("TAG", "onFailure: $t")
            }

        })

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MenuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ModulFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}
