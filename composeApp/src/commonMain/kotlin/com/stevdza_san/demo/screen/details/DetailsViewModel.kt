package com.stevdza_san.demo.screen.details

import androidx.lifecycle.ViewModel

class DetailsViewModel(val id: Int): ViewModel() {

    init {
        println("DetailsViewModel initialized...")
    }

    override fun onCleared() {
        super.onCleared()
        println("DetailsViewModel cleared...")
    }
}