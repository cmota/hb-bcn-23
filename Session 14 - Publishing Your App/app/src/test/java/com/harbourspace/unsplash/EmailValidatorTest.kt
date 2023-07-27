package com.harbourspace.unsplash

import com.harbourspace.unsplash.utils.isValidEmail
import junit.framework.TestCase.assertTrue
import org.junit.Test

class EmailValidatorTest {
    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue("name@email.com".isValidEmail())
    }
}
