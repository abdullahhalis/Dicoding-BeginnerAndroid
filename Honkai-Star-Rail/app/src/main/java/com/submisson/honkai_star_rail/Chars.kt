package com.submisson.honkai_star_rail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chars(
    val name: String,
    val description: String,
    val photo: String,
    val detailPhoto: String,
    val story: String,
    val link: String
) : Parcelable
