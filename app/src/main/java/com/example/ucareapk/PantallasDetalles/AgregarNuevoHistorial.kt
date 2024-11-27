package com.example.ucareapk.PantallasDetalles


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ucareapk.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistorialScreen(navController: NavHostController, padding: PaddingValues) {
    var tema by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var tiempo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Botón de regresar
        TextButton(
            onClick = { /* Acción para regresar */ },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text(
                text = "< Regresar",
                color = Color(0xFF5A5A5A),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Imagen de panda
        Image(
            painter = painterResource(id = R.drawable.osito), // Cambia por tu imagen
            contentDescription = "Panda",
            modifier = Modifier
                .size(150.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón "Agregar Nueva Historial"
        Button(
            onClick = { /* Acción para agregar historial */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(50.dp)
        ) {
            Text(text = "Agregar Nueva Historial", color = Color.White, fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para "Tema abordado"
        Text(
            text = "Tema abordado:",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = tema,
            onValueChange = { tema = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFD3D3D3), shape = RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFD3D3D3),
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para "Fecha de la sesión"
        Text(
            text = "Fecha de la sesión:",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = fecha,
            onValueChange = { fecha = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFD3D3D3), shape = RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFD3D3D3),
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para "Tiempo de la sesión"
        Text(
            text = "Tiempo de la sesión:",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = tiempo,
            onValueChange = { tiempo = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFD3D3D3), shape = RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFD3D3D3),
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón de confirmar
        Button(
            onClick = { /* Acción de guardar historial */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            modifier = Modifier
                .size(width = 80.dp, height = 50.dp)
        ) {
            Text(text = "✔", color = Color.White, fontSize = 24.sp)
        }
    }
}
