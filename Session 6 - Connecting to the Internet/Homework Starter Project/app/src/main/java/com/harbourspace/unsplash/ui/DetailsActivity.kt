package com.harbourspace.unsplash.ui

import android.os.Bundle
import androidx.compose.material3.Icon
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harbourspace.unsplash.R

private const val TAG = "DetailsActivity"

class DetailsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DetailsScreen()
        }
    }
}

@Composable
fun DetailsScreen() {
    LazyColumn {
        item {
            ImageSection()
        }

        item {
            AvatarAndIconRow()
        }

        item {
            InfoRow(
                title1 = stringResource(id = R.string.details_camera_title),
                subtitle1 = stringResource(id = R.string.details_camera_default),
                title2 = stringResource(id = R.string.details_aperture_title),
                subtitle2 = stringResource(id = R.string.details_aperture_default)
            )
        }

        item {
            InfoRow(
                title1 = stringResource(id = R.string.details_focal_title),
                subtitle1 = stringResource(id = R.string.details_focal_default),
                title2 = stringResource(id = R.string.details_shutter_title),
                subtitle2 = stringResource(id = R.string.details_shutter_default)
            )
        }

        item {
            InfoRow(
                title1 = stringResource(id = R.string.details_iso_title),
                subtitle1 = stringResource(id = R.string.details_iso_default),
                title2 = stringResource(id = R.string.details_dimensions_title),
                subtitle2 = stringResource(id = R.string.details_dimensions_default)
            )
        }

        item {
            Divider(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                thickness = 1.dp,
                color = Color.LightGray
            )
        }
        item {
            StatsRow(
                title1 = stringResource(id = R.string.details_views_title),
                subtitle1 = stringResource(id = R.string.details_views_default),
                title2 = stringResource(id = R.string.details_downloads_title),
                subtitle2 = stringResource(id = R.string.details_downloads_default),
                title3 = stringResource(id = R.string.details_likes_title),
                subtitle3 = stringResource(id = R.string.details_likes_default)
            )
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RoundedButton(textId = R.string.button1_text)
                Spacer(modifier = Modifier.width(8.dp))
                RoundedButton(textId = R.string.button2_text)
            }
        }
    }
}

@Composable
fun RoundedButton(@StringRes textId: Int) {
    Button(
        onClick = { /* Handle click */ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.DarkGray),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(6.dp)
    ) {
        Text(text = stringResource(id = textId))
    }
}

@Composable
fun ImageSection() {
    val imageRes = R.drawable.bcn_la_sagrada_familia

    Box(modifier = Modifier.fillMaxWidth().height(250.dp)) {

        Image(
            modifier = Modifier.matchParentSize(),
            painter = painterResource(id = imageRes),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(id = R.string.description_image_preview)
        )
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                painter = painterResource(id = R.drawable.ic_pin),
                contentDescription = stringResource(id = R.string.description_pin_icon),
                tint = Color.White

            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = stringResource(R.string.location),

                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun AvatarAndIconRow() {
    val avatarImage = R.drawable.avatar

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = avatarImage),
            contentDescription = stringResource(R.string.avatar_image),
            modifier = Modifier.size(50.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = "Maria B",
            fontSize = 20.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.weight(1f))

        Row {
            Icon(
                painter = painterResource(R.drawable.ic_like),
                contentDescription = stringResource(R.string.like_icon),
                modifier = Modifier.size(25.dp),
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(16.dp))

            Icon(
                painter = painterResource(R.drawable.ic_bookmark),
                contentDescription = stringResource(R.string.bookmark_icon),
                modifier = Modifier.size(30.dp),
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(16.dp))

            Icon(
                painter = painterResource(R.drawable.ic_download),
                contentDescription = stringResource(R.string.download_icon),
                modifier = Modifier.size(30.dp),
                tint = Color.White
            )
        }
    }
}

@Composable
fun InfoRow(
    title1: String,
    subtitle1: String,
    title2: String,
    subtitle2: String
) {
    Row(modifier = Modifier.padding(16.dp)) {
        Column(modifier = Modifier.weight(1.0f)) {
            AddImageInformation(title1, subtitle1)
        }

        Column(modifier = Modifier.weight(1.0f)) {
            AddImageInformation(title2, subtitle2)
        }
    }
}

@Composable
fun StatsRow(
    title1: String,
    subtitle1: String,
    title2: String,
    subtitle2: String,
    title3: String,
    subtitle3: String
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AddImageInformation(title1, subtitle1)
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AddImageInformation(title2, subtitle2)
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AddImageInformation(title3, subtitle3)
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
        fontWeight = FontWeight.Bold,
        color = Color.White

    )

    Text(
        text = subtitle,
        fontSize = 15.sp,
        color = Color.White

    )
}
