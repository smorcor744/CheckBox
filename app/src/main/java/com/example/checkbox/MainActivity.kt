package com.example.checkbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.checkbox.ui.theme.CheckBoxTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkMode by remember { mutableStateOf(false) }

            CheckBoxTheme(darkTheme = isDarkMode) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding),
                        isDarkMode = isDarkMode,
                        onThemeChange = { isDarkMode = it }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    isDarkMode: Boolean,
    onThemeChange: (Boolean) -> Unit
) {
    var boton by remember { mutableStateOf(false) }
    var checked by remember { mutableStateOf(false) }
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }
    var checked3 by remember { mutableStateOf(false) }

    val text: String = if (boton) {
        when {
            checked -> ""
            checked1 -> "Objetivo 1"
            checked2 -> "Objetivo 2"
            checked3 -> "Objetivo 3"
            else -> ""
        }
    } else {
        ""
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CheckBox(
            estado = checked1,
            onCheckedChange = { checked1 = it },
            text = "Objetivo 1"
        )
        CheckBox(
            estado = checked2,
            onCheckedChange = { checked2 = it },
            text = "Objetivo 2"
        )
        CheckBox(
            estado = checked3,
            onCheckedChange = { checked3 = it },
            text = "Objetivo 3"
        )

        Text(
            text = text,
            modifier = Modifier
                .height(100.dp)
                .width(150.dp)
                .border(1.dp, Color.Black),
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(
                checked = checked,
                onCheckedChange = { checked = it }
            )

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                onClick = { boton = !boton },
                enabled = !checked
            ) {
                Text(text = if (!boton) "Activar" else "Desactivar")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = if (isDarkMode) "Modo Oscuro" else "Modo Claro")
            Spacer(modifier = Modifier.width(10.dp))
            Switch(
                checked = isDarkMode,
                onCheckedChange = onThemeChange
            )
        }
    }
}

@Composable
fun CheckBox(estado: Boolean, onCheckedChange: (Boolean) -> Unit, text: String) {
    Row(
        modifier = Modifier.padding(bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = estado,
            onCheckedChange = onCheckedChange
        )
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CheckBoxTheme {
        Greeting(
            isDarkMode = false,
            onThemeChange = {}
        )
    }
}
