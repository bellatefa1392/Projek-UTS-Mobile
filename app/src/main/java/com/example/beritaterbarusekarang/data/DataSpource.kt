package com.example.beritaterbarusekarang.data

import com.example.beritaterbarusekarang.R
import com.example.beritaterbarusekarang.model.Tampil

class DataSource {
    // Mengembalikan daftar berita
    fun loadBerita(): List<Tampil> {
        return listOf(
            Tampil(R.string.berita_1, R.drawable.gambar1),
            Tampil(R.string.berita_2, R.drawable.gambar2),
            Tampil(R.string.berita_3, R.drawable.gambar3)
            // Tambahkan berita lainnya sesuai kebutuhan
        )
    }

    // Mengembalikan daftar arsip berita
    fun loadArsipBerita(): List<Tampil> {
        return listOf(
            Tampil(R.string.arsip_1, R.drawable.gambar1), // Ganti dengan gambar yang sesuai
            Tampil(R.string.arsip_2, R.drawable.gambar2), // Ganti dengan gambar yang sesuai
            Tampil(R.string.arsip_3, R.drawable.gambar3), // Ganti dengan gambar yang sesuai
        )
    }
}