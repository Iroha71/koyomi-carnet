package com.iroha71.koyomi_carnet.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppLayout(
    title: String,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold() {innerPadding ->
        Column(modifier = Modifier.padding(8.dp)) {
            content(innerPadding)
        }
    }
}