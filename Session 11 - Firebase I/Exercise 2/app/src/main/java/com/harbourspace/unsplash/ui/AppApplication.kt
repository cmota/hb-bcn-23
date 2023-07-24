package com.harbourspace.unsplash.ui

import android.app.Application
import com.harbourspace.unsplash.ui.repository.AppDatabase
import com.harbourspace.unsplash.ui.repository.UnsplashRepository

class AppApplication: Application() {

    val database by lazy { AppDatabase.getDatabase(this) }

    val repository by lazy { UnsplashRepository(database.unsplashDao()) }
}