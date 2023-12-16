package com.example.myapplication.ui.presentation.ui.MainActivity

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.ui.presentation.ui.home.HomeScreen
import com.example.myapplication.ui.presentation.utils.Screens

@Composable
fun NavHostController(navController: NavHostController) {
    val viewModel: MainViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Screens.Home.route) {
        composable(route = Screens.Home.route) {
            HomeScreen(onEvent = viewModel::onEvent)
        }
        composable(route = Screens.Detail.route) {
            DetailScreen {

            }
        }
    }
}