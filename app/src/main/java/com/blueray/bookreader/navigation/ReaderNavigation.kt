package com.blueray.bookreader.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.blueray.bookreader.screens.ReaderSplashScreen
import com.blueray.bookreader.screens.details.BookDetailsScreen
import com.blueray.bookreader.screens.home.HomeScreen
import com.blueray.bookreader.screens.login.ReaderLoginScreen
import com.blueray.bookreader.screens.search.ReaderBookSearchScreen
import com.blueray.bookreader.screens.update.ReaderBookUpdateScreen


@Composable
fun ReaderNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ReaderScreens.SplashScreen.name) {
        composable(ReaderScreens.SplashScreen.name) {
            ReaderSplashScreen(navController = navController)
        }

        composable(ReaderScreens.LoginScreen.name) {
            ReaderLoginScreen(navController = navController)
        }


        composable(ReaderScreens.ReaderHomePageScreen.name) {
            HomeScreen(navController = navController)
        }


        composable(ReaderScreens.SearchScreen.name) {
            ReaderBookSearchScreen(navController = navController)
        }

        composable(ReaderScreens.UpdateScreen.name) {
            ReaderBookUpdateScreen(navController = navController)
        }

        composable(ReaderScreens.DetailScreen.name) {
            BookDetailsScreen(navController = navController)
        }
    }


}