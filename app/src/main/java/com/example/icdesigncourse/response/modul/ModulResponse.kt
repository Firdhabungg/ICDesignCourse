package com.example.icdesigncourse.response.modul

data class ModulResponse(
    val id_modul : String,
    val nama_modul : String,
    val deskripsi_modul : String,
    val gambar_modul : String,
    val kelas_paket : String,
    val materi : String
)