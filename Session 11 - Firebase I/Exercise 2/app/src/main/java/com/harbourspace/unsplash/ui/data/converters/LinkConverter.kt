package com.harbourspace.unsplash.ui.data.converters

import androidx.room.TypeConverter
import com.harbourspace.unsplash.ui.data.Links
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class LinksConverter {

    @TypeConverter
    fun fromLinksType(value: Links?): String = Json.encodeToString(value)

    @TypeConverter
    fun toLinksType(value: String): Links? = Json.decodeFromString(value)
}