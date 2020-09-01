package com.example.belajaroop.database

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class  Quis (
    val id: Int,
    val title: String,
    val soal: String,
    val a: String,
    val b: String,
    val c: String,
    val d: String,
    val benar: String
): Parcelable