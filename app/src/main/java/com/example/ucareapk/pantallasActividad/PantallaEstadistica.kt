package com.example.ucareapk.pantallasActividad


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.navigation.NavHostController

@Composable
fun EstadisticasScreen(navController: NavHostController) {

    var reporteSeleccionado by remember { mutableStateOf("Mensual") }

    val datosMensuales = listOf(50f, 75f, 25f, 90f, 60f)
    val datosSemanales = listOf(8f, 12f, 10f, 15f, 9f)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MenuDesplegable(
            opciones = listOf("Mensual", "Semanal"),
            seleccionActual = reporteSeleccionado,
            onSeleccionar = { reporteSeleccionado = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        GraficosDeBarrasPersonalizados(
            datos = if (reporteSeleccionado == "Mensual") datosMensuales else datosSemanales,
            etiqueta = "Reporte $reporteSeleccionado"
        )

        Spacer(modifier = Modifier.height(16.dp))

        GraficoSemicircularPersonalizado(progreso = 75f)

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { navController.navigate("ExportarDatosScreen") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Exportar")
        }
    }
}

@Composable
fun MenuDesplegable(
    opciones: List<String>,
    seleccionActual: String,
    onSeleccionar: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        TextButton(onClick = { expanded = true }) {
            Text(text = seleccionActual)
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            opciones.forEach { opcion ->
                // Cambié DropdownMenuItem por un simple Text dentro del DropdownMenu
                TextButton(onClick = {
                    onSeleccionar(opcion)
                    expanded = false
                }) {
                    Text(text = opcion)
                }
            }
        }
    }
}

@Composable
fun GraficosDeBarrasPersonalizados(datos: List<Float>, etiqueta: String, modifier: Modifier = Modifier) {
    val maxValor = datos.maxOrNull() ?: 1f

    Canvas(modifier = Modifier.fillMaxWidth().height(200.dp)) {
        val espacioEntreBarras = 20.dp.toPx()
        val anchoBarra = (size.width - (espacioEntreBarras * (datos.size - 1))) / datos.size

        datos.forEachIndexed { index, valor ->
            val alturaBarra = (valor / maxValor) * size.height
            drawRect(
                color = Color.Green,
                topLeft = Offset(
                    x = (anchoBarra + espacioEntreBarras) * index,
                    y = size.height - alturaBarra
                ),
                size = Size(width = anchoBarra, height = alturaBarra)
            )
        }
    }

    Spacer(modifier = Modifier.height(8.dp))
    Text(text = etiqueta)
}

@Composable
fun GraficoSemicircularPersonalizado(progreso: Float, modifier: Modifier = Modifier) {
    val sweepAngle = (progreso / 100f) * 180f

    Canvas(modifier = Modifier.size(150.dp)) {
        drawArc(
            color = Color.LightGray,
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = false,
            style = Stroke(width = 16.dp.toPx())
        )
        drawArc(
            color = Color.Green,
            startAngle = 180f,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(width = 16.dp.toPx())
        )
    }
    Text(
        text = "${progreso.toInt()} horas trabajadas"
    )
}