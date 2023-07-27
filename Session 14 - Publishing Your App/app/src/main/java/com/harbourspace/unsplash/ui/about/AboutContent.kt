package com.harbourspace.unsplash.ui.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harbourspace.unsplash.R

@Composable
fun AboutContent(
    isDarkTheme: MutableState<Boolean>,
    updateDarkTheme: () -> Unit,
    onSignOut: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.about_dark_theme)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Switch(
                    checked = isDarkTheme.value,
                    onCheckedChange = { updateDarkTheme() }
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1.0f)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(id = R.string.about_text),
                fontSize = 19.sp,
                fontStyle = FontStyle.Normal
            )

            Spacer(modifier = Modifier.height(75.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_android),
                    contentDescription = stringResource(id = R.string.description_android),
                    modifier = Modifier.size(75.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_kotlin),
                    contentDescription = stringResource(id = R.string.description_kotlin),
                    modifier = Modifier.size(75.dp)
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onSignOut() }) {
                Text(
                    text = stringResource(id = R.string.about_sign_out),
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Normal
                )
            }
        }
    }
}