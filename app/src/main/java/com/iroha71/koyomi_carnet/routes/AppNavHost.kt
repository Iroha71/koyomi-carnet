package com.iroha71.koyomi_carnet.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iroha71.koyomi_carnet.views.About
import com.iroha71.koyomi_carnet.views.Home

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> { Home(onAboutClick = {navController.navigate(AbountRoute)}) }
        composable<AbountRoute> { About() }
    }
}