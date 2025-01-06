package com.example.icdesigncourse

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.icdesigncourse.client.RetrofitClient
import com.example.icdesigncourse.response.account.AkunResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuAkun.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuAkun : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

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
        return inflater.inflate(R.layout.fragment_menu_akun, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtUsername = view.findViewById<EditText>(R.id.isiUsername)
        val txtEmail = view.findViewById<EditText>(R.id.isiEmail1)
        val txtPass = view.findViewById<EditText>(R.id.isiPass)
        val txtNamaLengkap = view.findViewById<EditText>(R.id.isiNamaLengkap)
        val txtKelasPaket = view.findViewById<EditText>(R.id.paket)

        val simpanUsername = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val username = simpanUsername.getString("username", null)

        if (username != null) {

            RetrofitClient.instance.getAkun(username).enqueue(object : Callback<AkunResponse> {
                override fun onResponse(call: Call<AkunResponse>, response: Response<AkunResponse>) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        txtUsername.setText(data?.username)
                        txtEmail.setText(data?.email)
                        txtPass.setText(data?.password)
                        txtNamaLengkap.setText(data?.nama_lengkap)
                        txtKelasPaket.setText(data?.kelas_paket)
                    } else {
                        Toast.makeText(requireContext(), "Gagal mendapatkan data", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<AkunResponse>, t: Throwable) {
                    Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        } else {
            Toast.makeText(requireContext(), "User belum login", Toast.LENGTH_SHORT).show()
        }
        
        val txtLogout = view.findViewById<TextView>(R.id.logout)
        txtLogout.setOnClickListener {
            val intentLogout = Intent(requireContext(), MenuLogin::class.java)
            startActivity(intentLogout)
        }
    }
}

