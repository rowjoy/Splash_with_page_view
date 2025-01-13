package com.book.readbook

import AnimatedHeightPager
import SplashViews
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigator (){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash"){
            SplashViews(navController = navController)
        }
        composable(
            "pager",
            enterTransition = { slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(500)) },
        ){

            AnimatedHeightPager()
        }



    }
}