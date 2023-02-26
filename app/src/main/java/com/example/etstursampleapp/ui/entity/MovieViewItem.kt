package com.example.etstursampleapp.ui.entity

import android.os.Parcelable
import com.example.etstursampleapp.util.entity.ViewItem
import kotlinx.parcelize.Parcelize

@Parcelize
class MovieViewItem(
    val name: String,
    val posterPath: String,
    val backDropPath: String,
    val description: String,
    val country: String,
    val date: String,
    val voteAverage: Double
) : ViewItem, Parcelable