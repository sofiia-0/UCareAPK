package com.example.ucareapk.pantallasActividad


import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ExportarDatosScreen(navController: NavHostController, padding: PaddingValues) {


    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var formatoSeleccionado by remember { mutableStateOf("CSV") }

    val context = LocalContext.current  // Obtén el contexto aquí, dentro de @Composable

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Tipo de Archivo")  // Cambié a body1
        Column {
            listOf("CSV", "PDF", "Excel").forEach { formato ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = (formatoSeleccionado == formato),
                        onClick = { formatoSeleccionado = formato }
                    )
                    Text(text = formato)
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {


                // Ahora el Toast se muestra correctamente dentro de un @Composable
                Toast.makeText(
                    context,  // Usando 'context' que ahora está dentro del contexto @Composable
                    "Datos exportados como $formatoSeleccionado",
                    Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Exportar")
        }
    }
}