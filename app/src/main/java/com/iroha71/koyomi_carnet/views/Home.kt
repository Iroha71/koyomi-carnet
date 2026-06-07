package com.iroha71.koyomi_carnet.views

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.iroha71.koyomi_carnet.layouts.AppLayout
import com.iroha71.koyomi_carnet.ui.theme.KoyomicarnetTheme

@Composable
fun Home(
    onAboutClick: () -> Unit
) {
    AppLayout(title = "text") { _->
        Text(text = "test")
        Button(onClick = onAboutClick) {
            Text("About")
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