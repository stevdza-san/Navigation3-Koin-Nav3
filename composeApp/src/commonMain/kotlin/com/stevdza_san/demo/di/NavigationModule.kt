package com.stevdza_san.demo.di

import com.stevdza_san.demo.navigation.Navigator
import com.stevdza_san.demo.navigation.Screen
import com.stevdza_san.demo.screen.details.DetailsScreen
import com.stevdza_san.demo.screen.home.HomeScreen
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

@OptIn(KoinExperimentalAPI::class)
val navigationModule = module {
    single { Navigator(startDestination = Screen.Home) }

    navigation<Screen.Home> {
        HomeScreen(
            navigateToDetails = { number ->
                get<Navigator>().navigateTo(destination = Screen.Details(id = number))
            }
        )
    }

    navigation<Screen.Details> { route ->
        DetailsScreen(
            id = route.id,
            navigateBack = {
                get<Navigator>().goBack()
            }
        )
    }
}