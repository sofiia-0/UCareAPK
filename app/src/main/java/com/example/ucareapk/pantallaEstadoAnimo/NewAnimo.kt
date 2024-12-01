package com.example.ucareapk.pantallaEstadoAnimo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ucareapk.R

@Composable
fun RegistroAnimo(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp),
    ){
        Spacer(modifier = Modifier.height(30.dp))
        AtrasBoton(navController)
        Spacer(modifier = Modifier.height(16.dp))
        LogoNuevoAnimo()
        Spacer(modifier = Modifier.height(16.dp))
        ListEmotions()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListEmotions() {
    val emotions = listOf("Feliz", "Bien", "Triste", "Enojado", "Estresado")
    var selectedEmotion by remember { mutableStateOf("") }
    var isDropdownVisible by remember { mutableStateOf(false) }
    val cometarioState = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Estado de ánimo:",
            color = Color(0xFF5A5A5A),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Botón principal
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF9CA57B))
                .clickable { isDropdownVisible = !isDropdownVisible } // Alterna la visibilidad
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (selectedEmotion.isEmpty()) "Seleccionar estado" else selectedEmotion,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }

        // Dropdown con las opciones
        if (isDropdownVisible) {
            Spacer(modifier = Modifier.height(8.dp)) // Espaciado entre el botón y las opciones
            emotions.forEach { emotion ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            if (selectedEmotion == emotion) Color(0xFF9CA57B) else Color(0xFFE0E0E0)
                        )
                        .clickable {
                            selectedEmotion = emotion
                            isDropdownVisible = false // Oculta las opciones al seleccionar
                        }
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = emotion,
                        color = if (selectedEmotion == emotion) Color.White else Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
                Spacer(modifier = Modifier.height(8.dp)) // Espaciado entre opciones
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "Comentario: ",
            color = Color(0xFF5A5A5A),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = cometarioState.value,
            onValueChange = { cometarioState.value = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0xFF9CA57B),
                focusedBorderColor = Color(0xFF9CA57B),
                unfocusedBorderColor = Color(0xFF9CA57B),
                focusedTextColor = Color.White,
                cursorColor = Color.White
            ),
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20))
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { /* TODO: Handle search button click */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9CA57B)), // Color verde oscuro
            shape = RoundedCornerShape(20),
            modifier = Modifier.height(48.dp)) {
            Text(
                text = "Registrar",
                color = Color.White
            )
        }
    }
}



@Composable
fun LogoNuevoAnimo(){
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
                text = "Registro de estado de animo\no(*^▽^*)┛",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = (painterResource(id = R.drawable.pandaicon)),// Add your image resource
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(180.dp)
        )
    }
}