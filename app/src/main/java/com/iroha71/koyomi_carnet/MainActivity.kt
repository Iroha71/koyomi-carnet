package com.iroha71.koyomi_carnet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.iroha71.koyomi_carnet.routes.AppNavHost
import com.iroha71.koyomi_carnet.ui.theme.KoyomicarnetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoyomicarnetTheme {
                AppNavHost()
            }
        }
    }
}