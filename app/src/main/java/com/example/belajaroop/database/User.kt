package com.example.belajaroop.database
import android.os.Parcelable

import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    var nama: String? = null,
    var poin: String? = null
): Parcelable