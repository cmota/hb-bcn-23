package com.harbourspace.unsplash.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.harbourspace.unsplash.data.converters.LinksConverter
import com.harbourspace.unsplash.data.converters.ListCurrentUserCollectionConverter
import com.harbourspace.unsplash.data.converters.UrlsConverter
import com.harbourspace.unsplash.data.converters.UserConverter
import kotlinx.parcelize.Parcelize

@Entity("UnsplashItem")
@Parcelize
data class UnsplashItem(
    val blur_hash: String,
    val color: String,
    val created_at: String,

    @field:TypeConverters(ListCurrentUserCollectionConverter::class)
    val current_user_collections: List<CurrentUserCollection>,
    val description: String?,
    val height: Int,

    @PrimaryKey
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,

    @field:TypeConverters(LinksConverter::class)
    val links: Links,
    val updated_at: String,

    @field:TypeConverters(UrlsConverter::class)
    val urls: Urls,

    @field:TypeConverters(UserConverter::class)
    val user: User,
    val width: Int
) : Parcelable