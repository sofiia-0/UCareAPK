package com.example.ucareapk.pantallasRecordatorio


import android.app.TimePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.ucareapk.R
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgregarRecordatorio(navController: NavHostController) {
    var nombreRecordatorio by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("") }
    var realizado by remember { mutableStateOf("") }
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
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD5E8C8)),
                modifier = Modifier
                    .height(150.dp) // Ajusta la altura del botón según sea necesario
                    .weight(1f) // Ajusta el ancho del botón según sea necesario
            ) {
                Text(text = "Agregar nuevo Recordatorio", color = Color(0xFF6D6D6D), fontSize = 24.sp)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = nombreRecordatorio,
            onValueChange = { nombreRecordatorio = it },
            placeholder = { Text(text = "Nombre recordatorio") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFD5E8C8)
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    val timePickerDialog = TimePickerDialog(
                        context,
                        { _, hourOfDay, minute ->
                            val simpleDateFormat = SimpleDateFormat("HH:mm a", Locale.getDefault())
                            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                            calendar.set(Calendar.MINUTE, minute)
                            hora = simpleDateFormat.format(calendar.time)
                        },
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        false
                    )
                    timePickerDialog.show()
                }
                .background(Color(0xFFD5E8C8))
                .padding(16.dp)
        ) {
            Text(text = if (hora.isEmpty()) "Hora:" else hora, color = Color(0xFF6D6D6D))
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = realizado,
            onValueChange = { realizado = it },
            placeholder = { Text(text = "realizado") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFD5E8C8)
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD5E8C8))
        ) {
            Text(text = "✓", fontSize = 24.sp, color = Color(0xFF6D6D6D))
        }
    }
}


