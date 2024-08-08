package com.blueray.bookreader.navigation

enum class ReaderScreens {
    SplashScreen,
    LoginScreen,
    CreateAccountScreen,
    ReaderHomePageScreen,
    SearchScren,
    DetailScreen,
    UpdateScreen,
    SateScreen;

    companion object {
        fun fromRoute(route: String): ReaderScreens =
            when (route?.substringBefore("/")) {
                SplashScreen.name -> {}
                LoginScreen.name -> {}
                CreateAccountScreen.name -> {}
                ReaderHomePageScreen.name -> {}
                SearchScren.name -> {}
                DetailScreen.name -> {}
                UpdateScreen.name -> {}
                SateScreen.name -> {}
            }

    }

}