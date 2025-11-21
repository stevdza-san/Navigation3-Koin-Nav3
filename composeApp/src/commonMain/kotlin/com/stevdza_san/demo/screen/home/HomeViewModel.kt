package com.stevdza_san.demo.screen.home

import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    init {
        println("HomeViewmodel initialized...")
    }

    override fun onCleared() {
        super.onCleared()
        println("HomeViewmodel cleared...")
    }
}