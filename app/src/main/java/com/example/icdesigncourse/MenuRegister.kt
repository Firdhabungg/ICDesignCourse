package com.example.icdesigncourse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.privacysandbox.tools.core.model.Method
import com.android.volley.NetworkError
import com.android.volley.ServerError
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.icdesigncourse.client.RetrofitClient
import com.example.icdesigncourse.client.RetrofitClient.BASE_URL
import com.example.icdesigncourse.response.account.RegisterResponse
import com.squareup.picasso.Request
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuRegister : AppCompatActivity() {
    private lateinit var txtUsername: EditText
    private lateinit var txtPassword: EditText
    private lateinit var txtNamaLengkap: EditText
    private lateinit var txtEmail: EditText
    private lateinit var btnDaftar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_register)

        initializeViews()
        setupClickListeners()
    }

    private fun initializeViews() {
        txtUsername = findViewById(R.id.editEmailR)
//        txtEmail = findViewById(R.id.editEmailR)
        txtPassword = findViewById(R.id.editTextPass)
        txtNamaLengkap = findViewById(R.id.editTextNamaLengkap)
        btnDaftar = findViewById(R.id.buttonDaftar)
    }

    private fun setupClickListeners() {
        btnDaftar.setOnClickListener {
            if (validateInputs()) {
                registerUser()
            } else {
                Toast.makeText(this, "Lengkapi registrasi anda", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInputs(): Boolean {
        return txtUsername.text.isNotEmpty() &&
                txtPassword.text.isNotEmpty() &&
                txtNamaLengkap.text.isNotEmpty()
    }

    private fun registerUser() {
        val api = RetrofitClient.instance
        val registerCall = api.register(
            txtUsername.text.toString(),
            txtEmail.text.toString(),
            txtPassword.text.toString(),
            txtNamaLengkap.text.toString()
        )

        registerCall.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if (response.code() == 400) {
                    val errorBody = JSONObject(response.errorBody()?.string() ?: "{}")
                    val errorMessage = errorBody.optString("error", "Registrasi gagal")
                    Toast.makeText(this@MenuRegister, errorMessage, Toast.LENGTH_SHORT).show()
                } else if (response.isSuccessful) {
                    Toast.makeText(this@MenuRegister, "Registrasi Akun berhasil", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@MenuRegister, MenuLogin::class.java))
                    finish()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(this@MenuRegister, "Koneksi gagal", Toast.LENGTH_SHORT).show()
            }
        })
    }
}