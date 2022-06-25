package com.midterm.english_app.presentation.main.components

import com.midterm.english_app.presentation.navigation.NavScreen
import com.midterm.english_app.R

data class BottomNavItem(
    val title: String,
    val icon: Int,
    val route: String
)

fun provideBottomNavItems() = listOf(
    BottomNavItem(
        NavScreen.HomeScreen.route,
        R.drawable.home,
        NavScreen.HomeScreen.routeWithArgument
    ),
    BottomNavItem(
        NavScreen.BookmarkScreen.route,
        R.drawable.save,
        NavScreen.BookmarkScreen.route
    ),
    BottomNavItem(
        NavScreen.HistoryScreen.route,
        R.drawable.history,
        NavScreen.HistoryScreen.route
    )
)