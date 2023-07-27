package com.harbourspace.unsplash.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.TypeConverters
import com.harbourspace.unsplash.data.converters.ProfileImageConverter
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Entity
@Parcelize
@Serializable
data class User(
    val bio: String?,
    val id: String,
    val instagram_username: String?,
    val links: Links?,
    val location: String?,
    val name: String,
    val portfolio_url: String?,

    @field:TypeConverters(ProfileImageConverter::class)
    val profile_image: ProfileImage,
    val total_collections: Int,
    val total_likes: Int,
    val total_photos: Int,
    val twitter_username: String?,
    val username: String
) : Parcelable