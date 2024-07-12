package com.example.ucareapk.pantallasActividad

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ucareapk.R
import com.example.ucareapk.entity.Actividad


@Composable
fun PantallaActividad(navController: NavController, padding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        BackButton()
        Spacer(modifier = Modifier.height(16.dp))
        TitleSection()
        Spacer(modifier = Modifier.height(16.dp))
        ActionButtons(navController)
        Spacer(modifier = Modifier.height(16.dp))
        lazyData()
    }
}


@Composable
fun BackButton() {
    TextButton(
        onClick = { /* TODO: Handle back button click */ },
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
fun TitleSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(180.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF9CA57B)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Gestion de Actividades\n(°◡°)",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = R.drawable.pandacelular), // Add your image resource
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(180.dp)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActionButtons(navController: NavController) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            placeholder = { Text(text = "Buscar actividad", color = Color.White) },
            colors = TextFieldDefaults. outlinedTextFieldColors(
                containerColor = Color(0xFF3A3A24),
                focusedBorderColor = Color(0xFF3A3A24),
                unfocusedBorderColor = Color(0xFF3A3A24),
                focusedTextColor = Color.White,
                cursorColor = Color.White
            ),
            modifier = Modifier
                .height(50.dp)
                .clip(RoundedCornerShape(50))
                .size(260.dp)
        )

        IconButton(
            onClick = { navController.navigate("crearActividad") },
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFF3A3A24), CircleShape)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.plus), // Agrega tu recurso de icono de agregar
                contentDescription = "Agregar actividad",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
        IconButton(
            onClick = { /* TODO: Handle filter button click */ },
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFF3A3A24), CircleShape)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.filter), // Agrega tu recurso de icono de filtro
                contentDescription = "Filtrar actividades",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun lazyData() {
    val actividades = listOf(
        Actividad(1,false, "personal", "2024-07-20", "10:00 AM", "Ir al super"),
        Actividad(2,false, "academica", "2024-07-29", "11:00 AM", "Estudiar para Base de datos"),
        Actividad(3,false, "academica", "2024-07-30", "11:00 AM", "Entregar avances de proyecto"),
        Actividad(4,true, "academica", "2024-07-30", "11:00 AM", "Realizar tarea de analisis")
    )

    LazyColumn(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(actividades) { actividad ->
            Card(
                modifier = Modifier

                    .fillMaxWidth()
                    .padding(5.dp)
                    .clickable {
                        // Aquí puedes agregar la lógica para navegar al detalle de la actividad
                        // navController.navigate(DetailAgenda(actividad.id))
                    },
                colors = CardDefaults.cardColors(containerColor = Color(0xFF9CA57B)),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = actividad.nombre, fontWeight = FontWeight.Bold, color = Color.White)
                    Text(text = actividad.etiqueta, color = Color.White)
                    Text(text = actividad.fechaLimite, color = Color.White)
                    Text(text = actividad.horaLimite, color = Color.White)
                    Text(text = if (actividad.completada) "Realizada" else "No realizada", color = Color.White)
                }
            }
        }
    }
}