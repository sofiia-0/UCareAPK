package com.example.ucareapk.pantallasRecordatorio


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ucareapk.R

import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Recordatorios(navController: NavHostController) {
    var nombreRecordatorio by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("") }
    var prioridad by remember { mutableStateOf("") }
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            TextButton(
                onClick = { navController.popBackStack()},
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
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Recordatorios",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6D6D6D)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.osito), // Reemplaza con tu recurso de imagen
                contentDescription = "Panda",
                modifier = Modifier.size(190.dp) // Ajusta el tamaño de la imagen según sea necesario
            )
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { navController.popBackStack() },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD5E8C8)),
                modifier = Modifier
                    .height(150.dp) // Ajusta la altura del botón según sea necesario
                    .weight(1f) // Ajusta el ancho del botón según sea necesario
            ) {
                Text(text = "Nuevos Recordatorio", color = Color(0xFF6D6D6D), fontSize = 25.sp)
            }

            Spacer(modifier = Modifier.weight(2f)) // Empuja el botón hacia la parte inferior
            Button(
                onClick = { navController.navigate("AgregarRecordatorio") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6D6D6D)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Text(text = "+", color = Color.White, fontSize = 32.sp)
            }
        }

    }
}