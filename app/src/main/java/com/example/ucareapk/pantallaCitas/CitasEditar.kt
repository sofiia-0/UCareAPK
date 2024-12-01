package com.example.ucareapk.pantallaCitas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ucareapk.pantallasActividad.CheckboxPersonalizado
import com.example.ucareapk.pantallasActividad.DatePickerExample
import com.example.ucareapk.pantallasActividad.TimePickerExample

@Composable
fun CitasEdicion(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ){
        Spacer(modifier = Modifier.height(30.dp))
        ButtonRegresar(navController)
        Spacer(modifier = Modifier.height(30.dp))
        TituloCitas()
        Spacer(modifier = Modifier.height(10.dp))
        LineaDeSeparacion()
        Spacer(modifier = Modifier.height(10.dp))
        TituloEdicion()
        Spacer(modifier = Modifier.height(10.dp))
        OpcionesEdicion()
    }
}

@Composable
fun ButtonRegresar(navController: NavController) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OpcionesEdicion(){
    val actividadState = remember { mutableStateOf(TextFieldValue("")) }
    val etiquetaState = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        Text(
            "Nombre del estudiante: ",
            color = Color(0xFF5A5A5A),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = actividadState.value,
            onValueChange = { actividadState.value = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0xFF3A3A24),
                focusedBorderColor = Color(0xFF3A3A24),
                unfocusedBorderColor = Color(0xFF3A3A24),
                focusedTextColor = Color.White,
                cursorColor = Color.White
            ),
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20))
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            "Estado: ",
            color = Color(0xFF5A5A5A),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = etiquetaState.value,
            onValueChange = { etiquetaState.value = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0xFF9CA57B),
                focusedBorderColor = Color(0xFF9CA57B),
                unfocusedBorderColor = Color(0xFF9CA57B),
                focusedTextColor = Color.White,
                cursorColor = Color.White
            ),
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20))
        )
        Spacer(modifier = Modifier.height(5.dp))
        DatePickerExample()
        Spacer(modifier = Modifier.height(5.dp))
        TimePickerExample()
        Spacer(modifier = Modifier.height(40.dp))
        //boton
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { /* TODO: Handle search button click */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A3A24)), // Color verde oscuro
                shape = RoundedCornerShape(20),
                modifier = Modifier.height(48.dp)) {
                Text(
                    text = "Actualizar",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun TituloEdicion(){
    Box(
        modifier = Modifier
            .height(60.dp) // Altura del rectángulo
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp)) // Bordes redondeados
            .background(Color(0xFF9CA57B)), // Color verde similar
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Edición de cita ☆*: ",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
    }
}