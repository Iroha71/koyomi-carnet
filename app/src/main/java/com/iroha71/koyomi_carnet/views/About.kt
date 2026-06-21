package com.iroha71.koyomi_carnet.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.iroha71.koyomi_carnet.R
import com.iroha71.koyomi_carnet.layouts.AppLayout

@Composable
fun About() {
    AppLayout(title = stringResource(R.string.about_title)) {
        Text(stringResource(R.string.about_title))
    }
}