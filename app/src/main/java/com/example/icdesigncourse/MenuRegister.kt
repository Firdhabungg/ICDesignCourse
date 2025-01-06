package com.example.icdesigncourse

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.icdesigncourse.client.RetrofitClient
import com.example.icdesigncourse.response.account.RegisterResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuRegister : AppCompatActivity() {

    private lateinit var txtUsername: EditText
    private lateinit var txtPassword: EditText
    private lateinit var txtNamaLengkap: EditText
    private lateinit var btnDaftar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_register)

        initializeViews()
        setupClickListeners()
    }

    private fun initializeViews() {
        txtUsername = findViewById(R.id.editEmailR)
        txtPassword = findViewById(R.id.editTextPass)
        txtNamaLengkap = findViewById(R.id.editTextNamaLengkap)
        btnDaftar = findViewById(R.id.buttonDaftar)
    }

    private fun setupClickListeners() {
        btnDaftar.setOnClickListener {
            if (validateInputs()) {
                registerUser()
            } else {
                Toast.makeText(this, "Lengkapi registrasi Anda", Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<TextView>(R.id.tanyaMasuk).setOnClickListener {
            startActivity(Intent(this, MenuLogin::class.java))
        }
    }

    private fun validateInputs(): Boolean {
        return txtUsername.text.isNotEmpty() &&
                txtPassword.text.isNotEmpty() &&
                txtNamaLengkap.text.isNotEmpty()
    }

    private fun registerUser() {
        val username = txtUsername.text.toString()
        val password = txtPassword.text.toString()
        val namaLengkap = txtNamaLengkap.text.toString()

        val api = RetrofitClient.instance
        api.register(username, password, namaLengkap)
            .enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                    if (response.isSuccessful) {
                        val registerResponse = response.body()
                        if (registerResponse?.success == true) {
                            Toast.makeText(this@MenuRegister, registerResponse.message, Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@MenuRegister, MenuLogin::class.java))
                            finish()
                        } else {
                            Toast.makeText(this@MenuRegister, registerResponse?.message ?: "Registrasi gagal", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        // Parsing error body
                        val errorBody = response.errorBody()?.string()
                        val errorMessage = try {
                            JSONObject(errorBody ?: "{}").getString("message")
                        } catch (e: Exception) {
                            "Terjadi kesalahan"
                        }
                        Toast.makeText(this@MenuRegister, "Error: $errorMessage", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Toast.makeText(this@MenuRegister, "Koneksi gagal: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }
}