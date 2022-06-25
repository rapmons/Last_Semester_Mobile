package com.midterm.english_app

import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.navigation.compose.rememberNavController
import com.midterm.english_app.presentation.main.MainScreen
import com.midterm.english_app.presentation.main.components.BottomNavigationBar
import com.midterm.english_app.presentation.main.components.provideBottomNavItems
import com.midterm.english_app.presentation.ui.theme.EnglishWhizTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi


@ExperimentalMaterialApi
@ExperimentalAnimationApi
@InternalCoroutinesApi
@ExperimentalUnitApi
@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val THEME = "app_theme"
    val DARK_THEME = "dark_theme"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPreferences = this.getSharedPreferences(THEME, Context.MODE_PRIVATE)
        val themeEditor = sharedPreferences.edit()

        setContent {
            val currentTheme = sharedPreferences.getBoolean(DARK_THEME, isSystemInDarkTheme())
            if (currentTheme) setNightTheme()
            val toggleTheme = {
                if (currentTheme) {
                    setDayTheme()
                    themeEditor.putBoolean(DARK_THEME, false).apply()
                } else {
                    setNightTheme()
                    themeEditor.putBoolean(DARK_THEME, true).apply()
                }
            }

            EnglishWhizTheme {

                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    val scaffoldState = rememberScaffoldState()

                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(
                                items = provideBottomNavItems(),
                                navController
                            ) {
                                navController.navigate(it.route) {
                                    popUpTo(navController.graph.startDestinationId)
                                    launchSingleTop = true
                                }
                            }
                        }, scaffoldState = scaffoldState
                    ) {
                        Box(
                            modifier = Modifier.padding(
                                bottom = it.calculateBottomPadding()
                            )
                        ) {
                            MainScreen(
                                navController = navController,
                                scaffoldState = scaffoldState,
                                toggleTheme = toggleTheme
                            )
                        }
                    }
                }
            }
        }
    }

    private fun setDayTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun setNightTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }

    @Composable
    private fun isNightMode() = when (AppCompatDelegate.getDefaultNightMode()) {
        AppCompatDelegate.MODE_NIGHT_NO -> false
        AppCompatDelegate.MODE_NIGHT_YES -> true
        else -> isSystemInDarkTheme()
    }
}