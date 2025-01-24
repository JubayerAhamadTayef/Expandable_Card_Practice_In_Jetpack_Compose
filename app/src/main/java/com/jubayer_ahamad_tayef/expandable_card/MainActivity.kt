package com.jubayer_ahamad_tayef.expandable_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jubayer_ahamad_tayef.expandable_card.ui.theme.Expandable_CardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Expandable_CardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ExpendableCard(
                            cardTitle = "My Card",
                            cardDescription = "This is card description 1, \nThis is card description 2, \nThis is card description 3, \nThis is card description 4, \nThis is card description 5"
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Expandable_CardTheme {
        ExpendableCard(
            cardTitle = "My Card",
            cardDescription = "This is card description1, \nThis is card description2, \nThis is card description3, \nThis is card description4, \nThis is card description5"
        )
    }
}