package com.harbourspace.unsplash.data.converters

import androidx.room.TypeConverter
import com.harbourspace.unsplash.data.ProfileImage
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ProfileImageConverter {

    @TypeConverter
    fun fromProfileImageType(value: ProfileImage?): String = Json.encodeToString(value)

    @TypeConverter
    fun toProfileImageType(value: String): ProfileImage? = Json.decodeFromString(value)
}