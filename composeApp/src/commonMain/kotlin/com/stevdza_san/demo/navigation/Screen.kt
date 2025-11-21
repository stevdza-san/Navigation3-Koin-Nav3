package com.stevdza_san.demo.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    object Home

    @Serializable
    data class Details(val id: Int)
}