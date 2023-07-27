package com.harbourspace.unsplash

import android.content.Context
import android.content.SharedPreferences
import com.harbourspace.unsplash.repository.KEY_DARK_THEME
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.kotlin.mock

class MockedContextTest {

    @Mock
    val mockContext: Context = mock()

    @Mock val mockPrefs: SharedPreferences = mock()

    @Mock val mockEditor: SharedPreferences.Editor = mock()

    @Before
    @Throws(Exception::class)
    fun before() {
        Mockito.`when`(mockContext.getSharedPreferences(anyString(), anyInt()))
            .thenReturn(mockPrefs)
        Mockito.`when`(mockContext.getSharedPreferences(anyString(), anyInt()).edit())
            .thenReturn(mockEditor)
        Mockito.`when`(mockPrefs.getBoolean(KEY_DARK_THEME, false))
            .thenReturn(false)
    }

    @Test
    fun validateThemeSelection() {
        assertEquals(mockPrefs.getBoolean(KEY_DARK_THEME, false), false)
    }

}
