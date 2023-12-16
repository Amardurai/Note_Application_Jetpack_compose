package com.example.myapplication.ui.presentation.utils

sealed class Screens(val route:String) {

    object Home : Screens("Home")
    object Detail : Screens("Detail")


}