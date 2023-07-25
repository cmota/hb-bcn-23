package com.harbourspace.unsplash.data.converters

import androidx.room.TypeConverter
import com.harbourspace.unsplash.data.CurrentUserCollection
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ListCurrentUserCollectionConverter {

    @TypeConverter
    fun fromListCurrentUserCollectionType(value: List<CurrentUserCollection>?): String = Json.encodeToString(value)

    @TypeConverter
    fun toListCurrentUserCollectionType(value: String): List<CurrentUserCollection>? = Json.decodeFromString(value)
}