package com.example.ucareapk.pantallaEstadoAnimo

import android.app.DatePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ucareapk.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun PantallaEstadoAnimo(navController: NavController, padding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp),
        //horizontalAlignment = Alignment.CenterHorizontally // Centrar contenido horizontalmente
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        AtrasBoton(navController)
        Spacer(modifier = Modifier.height(16.dp))
        TituloEstadoAnimo()
        Spacer(modifier = Modifier.height(16.dp))
        OsoLogo() // Logo del panda
        Box( // Contenedor para centrar el botón del calendario
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            CalendarBoton(navController) // Solo este botón se centra
        }
    }
}

@Composable
fun AtrasBoton(navController: NavController) {
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
fun TituloEstadoAnimo(){
    Box(
        modifier = Modifier
            .height(60.dp) // Altura del rectángulo
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp)) // Bordes redondeados
            .background(Color(0xFF9CA57B)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Estado de animo (´▽`ʃ♡ƪ)",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
    }
}

@Composable
fun OsoLogo() {
    Box(
        contentAlignment = Alignment.Center, // Centra el contenido
        modifier = Modifier
            .fillMaxWidth() // Ocupa todo el ancho
            .padding(vertical = 16.dp) // Espaciado opcional
    ) {
        Image(
            painter = painterResource(id = R.drawable.pandacelular),
            contentDescription = "Panda",
            modifier = Modifier.size(350.dp), // Tamaño fijo del logo
            contentScale = ContentScale.Fit // Ajusta el contenido al tamaño del Image
        )
    }
}

@Composable
fun CalendarBoton(navController: NavController) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            calendar.set(year, month, dayOfMonth)
            navController.navigate("NuevoAnimo")
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    ).apply {
        calendar.add(Calendar.DAY_OF_YEAR, -10)
        datePicker.minDate = calendar.timeInMillis
        calendar.timeInMillis = System.currentTimeMillis()
        calendar.add(Calendar.DAY_OF_YEAR, 10)
        datePicker.maxDate = calendar.timeInMillis
    }

    Button(
        onClick = { datePickerDialog.show() },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9CA57B)),
        modifier = Modifier
            .width(200.dp)
            .height(60.dp)
    ) {
        Text(text = "Calendario", color = Color.White, fontSize = 25.sp)
    }
}
