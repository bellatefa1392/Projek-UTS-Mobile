package com.example.beritaterbarusekarang.data

import com.example.beritaterbarusekarang.R
import com.example.beritaterbarusekarang.model.Tampil

class DataSource() {
    fun loadAffirmations(): List<Tampil> {
        return listOf<Tampil>(
            Tampil(R.string.coba1, R.drawable.gambar1),
            Tampil(R.string.coba2, R.drawable.gambar2),
            Tampil(R.string.coba3, R.drawable.gambar3),
        )
    }
}
