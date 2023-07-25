package com.harbourspace.unsplash.data.cb

import com.harbourspace.unsplash.data.UnsplashCollection
import com.harbourspace.unsplash.data.UnsplashItem

interface UnsplashResult {

    fun onDataFetchedSuccess(images: List<UnsplashItem>)

    fun onCollectionsFetchedSuccess(collections: List<UnsplashCollection>)

    fun onDataFetchedFailed()
}