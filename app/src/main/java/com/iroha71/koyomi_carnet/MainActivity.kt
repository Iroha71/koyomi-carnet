package com.iroha71.koyomi_carnet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.iroha71.koyomi_carnet.layouts.AppLayout
import com.iroha71.koyomi_carnet.ui.theme.KoyomicarnetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoyomicarnetTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Main(name: String, modifier: Modifier = Modifier) {
    AppLayout(title = name) {
        innerPadding ->
        Column() {
            Text(text = "test")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KoyomicarnetTheme {
        Main("Android")
    }
}