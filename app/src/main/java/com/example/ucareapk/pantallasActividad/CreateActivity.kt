package com.example.ucareapk.pantallasActividad

import android.app.TimePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.ucareapk.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun CrearActividad(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        BackButtonAct(navController)
        Spacer(modifier = Modifier.height(16.dp))
        LogoCrearActividad()
        Spacer(modifier = Modifier.height(16.dp))
        OpcionesCreacion()
    }
}

@Composable
fun BackButtonAct(navController: NavController) {
    TextButton(
        onClick = {  navController.popBackStack() },
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
fun LogoCrearActividad() {
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
                text = "Crear Actividad\n(❁´◡`❁)",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = (painterResource(id = R.drawable.pandacelular)),// Add your image resource
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(180.dp)
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerExample() {
    val tiempoText = remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current
    val calendar = remember { Calendar.getInstance() }
    val timePickerDialog = remember {
        TimePickerDialog(
            context,
            { _, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                tiempoText.value = TextFieldValue(selectedTime)
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Text(
            "Hora: ",
            color = Color(0xFF5A5A5A),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Row {
            OutlinedTextField(
                value = tiempoText.value,
                onValueChange = { tiempoText.value = it },
                readOnly = true,
                label = {
                    Text(
                        "Seleccionar hora",
                        color = Color.White
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFF9CA57B),
                    focusedBorderColor = Color(0xFF9CA57B),
                    unfocusedBorderColor = Color(0xFF9CA57B),
                    focusedTextColor = Color.White,
                    cursorColor = Color.White
                ),
                modifier = Modifier
                    .height(60.dp)
                    .clip(RoundedCornerShape(20))
                    .clickable { timePickerDialog.show() }
            )
            Icon(
                painter = painterResource(id = R.drawable.clock),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(5.dp)
                    .clickable { timePickerDialog.show() }
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerExample() {
    val dateText = remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current
    val calendar = remember { Calendar.getInstance() }
    val datePickerDialog = remember {
        android.app.DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                calendar.set(year, month, dayOfMonth)
                val selectedDate = simpleDateFormat.format(calendar.time)
                dateText.value = TextFieldValue(selectedDate)
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
    }

    Column(
        modifier = Modifier
            .background(Color.White)
    ) {
        Text(
            "Fecha: ",
            color = Color(0xFF5A5A5A),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Row {
            OutlinedTextField(
                value = dateText.value,
                onValueChange = { dateText.value = it },
                readOnly = true,
                label = {
                    Text(
                        "Seleccionar fecha",
                        color = Color.White
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFF9CA57B),
                    focusedBorderColor = Color(0xFF9CA57B),
                    unfocusedBorderColor = Color(0xFF9CA57B),
                    focusedTextColor = Color.White,
                    cursorColor = Color.White
                ),
                modifier = Modifier
                    .height(60.dp)
                    .clip(RoundedCornerShape(20))
                    .clickable { datePickerDialog.show() }
            )
            Icon(
                painter = painterResource(id = R.drawable.calendar),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(5.dp)
                    .clickable { datePickerDialog.show() }
            )
        }
    }
}

@Composable
fun CheckboxPersonalizado() {
    // Estado para controlar el estado del checkbox
    val checkedState = remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        // Checkbox con el color verde personalizado
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFF3A3A24) // Color verde oscuro
            ),modifier = Modifier.size(36.dp)
        )

        // Texto asociado al checkbox
        Text(
            text = "Marcar como realizado",
            color = Color.Black, // Color del texto
            modifier = Modifier.padding(start = 8.dp), // Espacio entre el checkbox y el texto
            fontSize = 20.sp
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OpcionesCreacion() {
    val actividadState = remember { mutableStateOf(TextFieldValue("")) }
    val etiquetaState = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        Text(
            "Actividad: ",
            color = Color(0xFF5A5A5A),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = actividadState.value,
            onValueChange = { actividadState.value = it },
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
        Text(
            "Etiqueta: ",
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
        Spacer(modifier = Modifier.height(10.dp))
        CheckboxPersonalizado()
        Spacer(modifier = Modifier.height(20.dp))
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
                    text = "Crear",
                    color = Color.White
                )
            }
        }
    }
}