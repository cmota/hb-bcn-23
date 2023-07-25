package com.harbourspace.unsplash.data

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Entity
@Parcelize
@Serializable
data class Links(
    val download: String?,
    val download_location: String?,
    val html: String?,
    val likes: String?,
    val photos: String?,
    val portfolio: String?,
    val self: String?
) : Parcelable