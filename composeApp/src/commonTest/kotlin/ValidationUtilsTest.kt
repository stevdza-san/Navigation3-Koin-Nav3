package com.stevdza_san.demo.flow

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// Example utility functions that could be extracted from the login screen
object ValidationUtils {
    fun isValidUsername(username: String): Boolean {
        return username.isNotBlank()
    }

    fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }

    fun validateCredentials(username: String, password: String): String? {
        return when {
            username.isEmpty() -> "Username is required"
            password.isEmpty() -> "Password is required"
            password.length < 6 -> "Password must be at least 6 characters"
            username == "admin" && password == "password123" -> null // Valid
            else -> "Invalid credentials"
        }
    }
}

// Unit tests - these run on JVM, no Android runtime needed
class ValidationUtilsTest {

    @Test
    fun isValidUsername_returnsTrueForNonBlankUsername() {
        // Arrange
        val username = "testuser"

        // Act
        val result = ValidationUtils.isValidUsername(username)

        // Assert
        assertTrue(result)
    }

    @Test
    fun isValidUsername_returnsFalseForBlankUsername() {
        // Arrange & Act & Assert
        assertFalse(ValidationUtils.isValidUsername(""))
        assertFalse(ValidationUtils.isValidUsername("   "))
    }

    @Test
    fun isValidPassword_returnsTrueForPasswordWithSixOrMoreCharacters() {
        // Arrange & Act & Assert
        assertTrue(ValidationUtils.isValidPassword("123456"))
        assertTrue(ValidationUtils.isValidPassword("password123"))
    }

    @Test
    fun isValidPassword_returnsFalseForPasswordWithLessThanSixCharacters() {
        // Arrange & Act & Assert
        assertFalse(ValidationUtils.isValidPassword("123"))
        assertFalse(ValidationUtils.isValidPassword("12345"))
    }

    @Test
    fun validateCredentials_returnsNullForValidCredentials() {
        // Arrange
        val username = "admin"
        val password = "password123"

        // Act
        val result = ValidationUtils.validateCredentials(username, password)

        // Assert
        assertEquals(null, result)
    }

    @Test
    fun validateCredentials_returnsErrorMessageForEmptyUsername() {
        // Arrange
        val username = ""
        val password = "password123"

        // Act
        val result = ValidationUtils.validateCredentials(username, password)

        // Assert
        assertEquals("Username is required", result)
    }

    @Test
    fun validateCredentials_returnsErrorMessageForEmptyPassword() {
        // Arrange
        val username = "testuser"
        val password = ""

        // Act
        val result = ValidationUtils.validateCredentials(username, password)

        // Assert
        assertEquals("Password is required", result)
    }

    @Test
    fun validateCredentials_returnsErrorMessageForShortPassword() {
        // Arrange
        val username = "testuser"
        val password = "123"

        // Act
        val result = ValidationUtils.validateCredentials(username, password)

        // Assert
        assertEquals("Password must be at least 6 characters", result)
    }

    @Test
    fun validateCredentials_returnsErrorMessageForInvalidCredentials() {
        // Arrange
        val username = "wronguser"
        val password = "wrongpassword"

        // Act
        val result = ValidationUtils.validateCredentials(username, password)

        // Assert
        assertEquals("Invalid credentials", result)
    }
}