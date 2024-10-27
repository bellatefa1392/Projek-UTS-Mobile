package com.example.beritaterbarusekarang.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tampil(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
