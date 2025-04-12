package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var num1 by remember {
                mutableStateOf(value = "0")
            }

            var num2 by remember {
                mutableStateOf(value = "0")
            }

            var result by remember {
                mutableStateOf(value = "")
            }

            Column {
                TextField(value = num1, onValueChange = {
                    num1 = it;
                })
                Spacer(modifier = Modifier.height(8.dp))
                TextField(value = num2, onValueChange = {
                    num2 = it;
                })

                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Button(onClick = {
                        val a = num1.toIntOrNull()
                        val b = num2.toIntOrNull()
                        result = if (a != null && b != null) {
                            (a + b).toString()
                        } else {
                            "Input tidak valid"
                        }
                    }) {
                        Text(text = "Add")
                    }

                    Button(onClick = {
                        val a = num1.toIntOrNull()
                        val b = num2.toIntOrNull()
                        result = if (a != null && b != null) {
                            (a - b).toString()
                        } else {
                            "Input tidak valid"
                        }
                    }) {
                        Text(text = "Sub")
                    }

                    Button(onClick = {
                        val a = num1.toIntOrNull()
                        val b = num2.toIntOrNull()
                        result = if (a != null && b != null) {
                            (a * b).toString()
                        } else {
                            "Input tidak valid"
                        }
                    }) {
                        Text(text = "Mul")
                    }

                    Button(onClick = {
                        val a = num1.toDoubleOrNull()
                        val b = num2.toDoubleOrNull()
                        result = if (a == null || b == null || b == 0.0) {
                            "Tidak bisa dibagi 0"
                        } else {
                            (a / b).toString()
                        }
                    }) {
                        Text(text = "Div")
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Hasil: $result",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}

