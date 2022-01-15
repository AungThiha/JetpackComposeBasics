package com.jetpack.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetpack.compose.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicsTheme {
                MyApp()
            }
        }
    }
}

@Composable
private fun MyApp(names: List<String> = listOf("World", "Compose")) {
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(vertical = 4.dp)) {
            names.forEach { name ->
                Greeting(name)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    val expanded = remember {
        mutableStateOf(false)
    }

    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .padding(bottom = extraPadding)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Hello,")
                Text(text = name)
            }
            OutlinedButton(
                onClick = { expanded.value = !expanded.value },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                val text = if (expanded.value) "Show less" else "Show more"
                Text(text = text)
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    JetpackComposeBasicsTheme {
        Greeting("Android")
    }
}