package com.harbourspace.unsplash.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.harbourspace.unsplash.ui.UnsplashViewModel
import com.harbourspace.unsplash.ui.data.UnsplashItem

@Composable
fun MainScreen(
    unsplashViewModel: UnsplashViewModel,
    openDetailsActivity: (UnsplashItem) -> Unit
) {
    val selected = remember { mutableStateOf(0) }

    Column {

        val actions = listOf(
            com.harbourspace.unsplash.ui.Tab.HOME,
            com.harbourspace.unsplash.ui.Tab.COLLECTIONS
        )
        TabRow(
            selectedTabIndex = selected.value,
            divider = {}
        ) {
            actions.forEachIndexed { index, tab ->
                Tab(
                    modifier = Modifier.height(48.dp),
                    selected = selected.value == index,
                    onClick = { selected.value = index }
                ) {
                    Text(
                        text = stringResource(id = com.harbourspace.unsplash.ui.Tab.values()[index].tab)
                    )
                }
            }
        }

        when(selected.value) {
            com.harbourspace.unsplash.ui.Tab.HOME.ordinal -> {
                MainContent(
                    unsplashViewModel = unsplashViewModel,
                    openDetailsActivity = { item -> openDetailsActivity(item) }
                )
            }

            com.harbourspace.unsplash.ui.Tab.COLLECTIONS.ordinal -> {
                CollectionsContent(
                    unsplashViewModel = unsplashViewModel
                )
            }
        }
    }
}