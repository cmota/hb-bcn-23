package com.harbourspace.unsplash.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.harbourspace.unsplash.R
import com.harbourspace.unsplash.ui.data.UnsplashItem
import com.harbourspace.unsplash.ui.navigation.BottomNavigationScreen
import com.harbourspace.unsplash.ui.repository.AppPreferences
import com.harbourspace.unsplash.ui.theme.UnsplashTheme

enum class Tab(@StringRes val tab: Int) {
    HOME(R.string.main_tab_images),
    COLLECTIONS(R.string.main_tab_collections)
}

class MainActivity : ComponentActivity() {

    private val unsplashViewModel: UnsplashViewModel by viewModels {
        UnsplashViewModel((application as AppApplication).repository)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        unsplashViewModel.fetchImages()
        unsplashViewModel.fetchCollections()

        setContent {

            val activity = this

            val isDarkTheme = remember { mutableStateOf(AppPreferences(activity).isDarkTheme()) }

            UnsplashTheme(
                darkTheme = isDarkTheme.value
            ) {

                val navController = rememberNavController()

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(stringResource(id = R.string.app_name))
                            }
                        )
                    },
                    bottomBar = {
                        val items = listOf(
                            BottomNavigationScreen.Home,
                            BottomNavigationScreen.About
                        )

                        val selected = remember { mutableStateOf(0) }

                        NavigationBar {
                            items.forEachIndexed { index, screen ->
                                NavigationBarItem(
                                    selected = selected.value == index,
                                    onClick = {
                                        selected.value = index
                                        navController.navigate(screen.route)
                                    },
                                    icon = {
                                        Icon(
                                            painter = painterResource(id = screen.drawResId),
                                            contentDescription = stringResource(id = screen.stringResId),
                                            modifier = Modifier.size(24.dp)
                                        )
                                    },
                                    label = {
                                        Text(
                                            stringResource(id = screen.stringResId)
                                        )
                                    })
                            }
                        }
                    }
                ) {

                    Column(
                        modifier = Modifier.padding(it)
                    ) {
                        NavHost(navController, startDestination = BottomNavigationScreen.Home.route) {
                            composable(BottomNavigationScreen.Home.route) {
                                MainScreen(
                                    unsplashViewModel = unsplashViewModel,
                                    openDetailsActivity = { openDetailsActivity(it) }
                                )
                            }

                            composable(BottomNavigationScreen.About.route) {
                                AboutContent(
                                    isDarkTheme = isDarkTheme,
                                    updateDarkTheme = {
                                        isDarkTheme.value = !isDarkTheme.value
                                        AppPreferences(activity).setForceDarkTheme(isDarkTheme.value)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun openDetailsActivity(item: UnsplashItem) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(EXTRA_IMAGE, item)
        startActivity(intent)
    }
}