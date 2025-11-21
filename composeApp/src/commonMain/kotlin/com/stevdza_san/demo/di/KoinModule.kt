package com.stevdza_san.demo.di

import com.stevdza_san.demo.screen.details.DetailsViewModel
import com.stevdza_san.demo.screen.home.HomeViewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val mainModules = module {
    viewModel { HomeViewModel() }
    viewModel { params -> DetailsViewModel(id = params.get()) }
}

fun initializeKoin(
    config: (KoinApplication.() -> Unit)? = null,
) {
    startKoin {
        config?.invoke(this)
        modules(mainModules, navigationModule)
    }
}