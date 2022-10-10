package com.belhyto.signway.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.belhyto.signway.SignMenu
import com.belhyto.signway.SignSplash
import com.belhyto.signway.SignWelcome

@Composable
fun SetupNavGraph(navController: NavHostController)
{
    NavHost(navController = navController,
        startDestination = Screen.Splash.route )
    {
        composable(route = Screen.Splash.route)
        {
            SignSplash(navController=navController)
        }
        composable(route= Screen.Home.route)
        {
           SignWelcome(navController=navController)
        }
        composable(route= Screen.Menu.route)
        {
            SignMenu(navController=navController)
        }

    }
}