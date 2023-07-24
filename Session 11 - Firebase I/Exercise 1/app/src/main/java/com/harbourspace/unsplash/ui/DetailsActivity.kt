package com.harbourspace.unsplash.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.harbourspace.unsplash.R
import com.harbourspace.unsplash.ui.data.UnsplashItem
import com.harbourspace.unsplash.ui.repository.AppPreferences
import com.harbourspace.unsplash.ui.theme.UnsplashTheme

class DetailsActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val image = intent.extras!!.get(EXTRA_IMAGE) as UnsplashItem

        setContent {
            UnsplashTheme(
                darkTheme = AppPreferences(this).isDarkTheme()
            ) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = stringResource(id = R.string.app_name))
                            },
                            navigationIcon = {
                                IconButton(onClick = { finish()}) {
                                    Icon(
                                        imageVector = Icons.Filled.ArrowBack,
                                        contentDescription = stringResource(id = R.string.description_back)
                                    )
                                }
                            }
                        )
                    }
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {

                        DetailsContent(image = image)
                    }
                }
            }
        }
    }
}

@Composable
fun AddImageInformation(
    title: String,
    subtitle: String
) {

    Text(
        text = title,
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold
    )

    Text(
        text = subtitle,
        fontSize = 15.sp
    )
}