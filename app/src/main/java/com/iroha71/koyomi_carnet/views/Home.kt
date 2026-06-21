package com.iroha71.koyomi_carnet.views

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.iroha71.koyomi_carnet.R
import com.iroha71.koyomi_carnet.layouts.AppLayout
import com.iroha71.koyomi_carnet.ui.theme.KoyomicarnetTheme

@Composable
fun Home(
    onAboutClick: () -> Unit
) {
    AppLayout(title = stringResource(R.string.home_title)) { _->
        Text(text = "test")
        Button(onClick = onAboutClick) {
            Text(stringResource(R.string.about_title))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    KoyomicarnetTheme {
        Home(onAboutClick = {})
    }
}