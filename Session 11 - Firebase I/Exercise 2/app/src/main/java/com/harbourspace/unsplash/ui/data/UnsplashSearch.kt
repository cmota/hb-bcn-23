package com.harbourspace.unsplash.ui.data

import androidx.room.Entity

@Entity
data class UnsplashSearch(
    val results: List<UnsplashItem>,
    val total: Int,
    val total_pages: Int
)