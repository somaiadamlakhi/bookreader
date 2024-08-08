package com.blueray.bookreader.navigation

enum class ReaderScreens {
    SplashScreen,
    LoginScreen,
    CreateAccountScreen,
    ReaderHomePageScreen,
    SearchScreen,
    DetailScreen,
    UpdateScreen,
    SateScreen;

    companion object {
        fun fromRoute(route: String?): ReaderScreens =
            when (route?.substringBefore("/")) {
                SplashScreen.name -> SplashScreen
                LoginScreen.name -> LoginScreen
                CreateAccountScreen.name -> CreateAccountScreen
                ReaderHomePageScreen.name -> ReaderHomePageScreen
                SearchScreen.name -> SearchScreen
                DetailScreen.name -> DetailScreen
                UpdateScreen.name -> UpdateScreen
                SateScreen.name -> SateScreen
                null -> ReaderHomePageScreen
                else -> throw IllegalArgumentException("Route $route is not recognized")
            }

    }

}