package com.example.ucareapk.pantallaCitas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ucareapk.R
import com.example.ucareapk.entity.Actividad
import com.example.ucareapk.entity.Citas


@Composable
fun CitasPsicologo(navController: NavController, padding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        RegresarBoton(navController)
        Spacer(modifier = Modifier.height(30.dp))
        TituloCitas()
        Spacer(modifier = Modifier.height(10.dp))
        LineaDeSeparacion()
        Spacer(modifier = Modifier.height(10.dp))
        BotonesCitas()
        Spacer(modifier = Modifier.height(10.dp))
        CitasData()
    }
}

@Composable
fun RegresarBoton(navController: NavController) {
    TextButton(
        onClick = { navController.popBackStack() },
        modifier = Modifier
            .height(48.dp)
            .padding(horizontal = 16.dp)
    ) {
        Text(
            "< Regresar",
            color = Color(0xFF5A5A5A),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun TituloCitas() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        //cuadro de citas
        Box(
            modifier = Modifier
                .height(60.dp) // Altura del rectángulo
                .weight(1f) // Ocupa todo el espacio horizontal disponible
                .clip(RoundedCornerShape(12.dp)) // Bordes redondeados
                .background(Color(0xFF9CA57B)), // Color verde similar
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Citas",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }//termina box
        Spacer(modifier = Modifier.width(16.dp))
        Box(
            modifier = Modifier
                .size(60.dp) // Tamaño del cuadrado
                .clip(RoundedCornerShape(12.dp))
                .background(color = Color(0xFF9CA57B)),
            contentAlignment = Alignment.Center // Centrar la imagen dentro del Box
        ) {
            Image(
                painter = painterResource(id = R.drawable.pandaicon),
                contentDescription = null, // Texto alternativo
                contentScale = ContentScale.Crop, // Escalar la imagen dentro del espacio
                modifier = Modifier.size(70.dp)
            )
        }
    }
}

@Composable
fun LineaDeSeparacion() {
    Box(
        modifier = Modifier
            .fillMaxWidth() // Ocupa todo el ancho disponible
            .height(1.dp) // Altura de la línea
            .background(Color(0xFF3A3A24)) //color verde oscuro
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BotonesCitas() {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Row(
        horizontalArrangement = Arrangement.Start, // Alinea los elementos al inicio horizontalmente
        verticalAlignment = Alignment.CenterVertically, // Centra verticalmente dentro de la fila
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp)
    ) {
        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            placeholder = { Text(text = "Buscar cita",
                color = Color.White,
                fontWeight = FontWeight.Bold, // Texto en negrita
                fontSize = 18.sp // Tamaño de fuente más grande
                         ) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0xFF3A3A24),
                focusedBorderColor = Color(0xFF3A3A24),
                unfocusedBorderColor = Color(0xFF3A3A24),
                focusedTextColor = Color.White,
                cursorColor = Color.White
            ),
            modifier = Modifier
                .height(50.dp)
                .clip(RoundedCornerShape(30))
                .width(260.dp) // Ajusta el ancho del campo de texto
        )
        Spacer(modifier = Modifier.width(10.dp)) // Espacio entre el TextField y el IconButton
        IconButton(
            onClick = { /* TODO: Handle filter button click */ },
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFF3A3A24), CircleShape)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.filter), // Agrega tu recurso de icono de filtro
                contentDescription = "Filtrar citas",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun CitasData() {
    val citas = listOf(
        Citas(1,"Maria", "Alejandra", "2024-07-20", "10:00 AM", "Pendiente"),
        Citas(3,"Mario", "Alfredo", "2024-06-20", "10:00 AM", "Completado"),
        Citas(2,"Juan", "Juanin", "2024-07-28", "10:00 AM", "Cancelada")
    )

    LazyColumn(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(citas) { cita ->
            // Definir el color dependiendo del estado de la cita
            val backgroundColor = when (cita.estado) {
                "Pendiente" -> Color(0xFF9CA57B) // Verde claro
                "Completado" -> Color(0xFF3A3A24) // Verde oscuro
                "Cancelada" -> Color(0xFF715857) // Gris
                else -> Color.Gray // Color por defecto
            }

            var expanded by remember { mutableStateOf(false) } // Estado del DropdownMenu

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .clickable {
                        expanded = true // Muestra el menú de opciones cuando la tarjeta es tocada
                    },
                colors = CardDefaults.cardColors(containerColor = backgroundColor), // Asignamos el color al Card
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "${cita.estudianteNombre} ${cita.estudianteApellido}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp, // Tamaño de fuente más grande
                        color = Color.White
                    )
                    Text(text = cita.fechaLimite, color = Color.White)
                    Text(text = cita.horaLimite, color = Color.White)
                    Text(
                        text = "Estado: ${cita.estado}",
                        color = Color.White
                    )
                }
            }

            // Mostrar el menú de opciones cuando la tarjeta es tocada
            if (expanded) {
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false } // Cerrar el menú cuando el usuario haga clic fuera
                ) {
                    DropdownMenuItem(
                        text = { Text("Cancelar") },
                        onClick = {
                            // Aquí puedes implementar la lógica de cancelación
                            // Por ejemplo, puedes cambiar el estado de la cita a "Cancelada" en tu lista o ViewModel
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Editar") },
                        onClick = {
                            // No hace nada por ahora, solo cierra el menú
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}


