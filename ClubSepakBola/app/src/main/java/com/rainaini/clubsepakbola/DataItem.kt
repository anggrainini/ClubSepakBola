package com.rainaini.clubsepakbola

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// pembuatan kelas dataitem dengan atribut text namaclub, image gambar, text detail dengan kembalian berupa Parcelable androidExtensions=true

@Parcelize
data class DataItem(val namaclub: String?, val gambar: Int?, val detail: String?) : Parcelable