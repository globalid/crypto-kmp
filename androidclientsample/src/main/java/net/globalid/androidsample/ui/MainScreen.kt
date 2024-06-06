package net.globalid.androidsample.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.globalid.androidsample.ui.theme.CryptokmpTheme

@Composable
fun MainScreen(innerPadding: PaddingValues) {
    Greeting(
        name = "Android",
        modifier = Modifier.padding(innerPadding)
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CryptokmpTheme {
        Greeting("Android")
    }
}