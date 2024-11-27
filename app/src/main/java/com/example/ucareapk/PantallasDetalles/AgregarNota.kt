package com.example.ucareapk.PantallasDetalles



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
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
fun NotaScreen(navController: NavHostController) {
    var nota by remember { mutableStateOf("") }

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
            painter = painterResource(id = R.drawable.pandacelular), // Cambia por tu imagen
            contentDescription = "Panda",
            modifier = Modifier
                .size(150.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón "Agregar nueva nota"
        Button(
            onClick = { /* Acción para agregar nota */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(50.dp)
        ) {
            Text(text = "Agregar nueva nota", color = Color.White, fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Caja de texto para la nota
        Text(
            text = "Nota:",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = nota,
            onValueChange = { nota = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color(0xFFD3D3D3), shape = RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFD3D3D3),
                cursorColor = Color.Black, // Color del cursor
                focusedIndicatorColor = Color.Transparent, // Sin borde enfocado
                unfocusedIndicatorColor = Color.Transparent, // Sin borde desenfocado

            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón de confirmar
        Button(
            onClick = { /* Acción de guardar nota */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            modifier = Modifier
                .size(width = 80.dp, height = 50.dp)
        ) {
            Text(text = "✔", color = Color.White, fontSize = 24.sp)
        }
    }
}
