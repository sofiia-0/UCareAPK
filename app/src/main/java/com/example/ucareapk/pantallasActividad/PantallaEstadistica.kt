import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ucareapk.R

@Composable
fun ReporteMensualScreen(modifier: Modifier = Modifier) {
    var seleccionReporte by remember { mutableStateOf("Mensual") }
    var dropdownExpanded by remember { mutableStateOf(false) }

    val opcionesReporte = if (seleccionReporte == "Mensual") {
        listOf("May", "Jun", "Jul", "Ago", "Sept")
    } else {
        listOf("1", "2", "3", "4", "5")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Selector entre mensual y semanal
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { dropdownExpanded = true }) {
                Text(text = seleccionReporte)
            }

            DropdownMenu(
                expanded = dropdownExpanded,
                onDismissRequest = { dropdownExpanded = false }
            ) {
                listOf("Mensual", "Semanal").forEach { opcion ->
                    DropdownMenuItem(
                        text = { Text(opcion) }, // Define el texto de forma explícita
                        onClick = {
                            seleccionReporte = opcion
                            dropdownExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Título del gráfico
        Text(
            text = seleccionReporte,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Imagen del gráfico
        Image(
            painter = painterResource(id = R.drawable.reporte_mensual), // Reemplaza con tu recurso
            contentDescription = "Gráfico",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Imagen del progreso semanal
        Image(
            painter = painterResource(id = R.drawable.progreso_semanal), // Reemplaza con tu recurso
            contentDescription = "Progreso Semanal",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Botón Exportar
        Button(onClick = {  }) {
            Text(text = "Exportar")
        }
    }
}