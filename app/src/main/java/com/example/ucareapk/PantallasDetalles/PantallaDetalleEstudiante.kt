package com.example.ucareapk.PantallasDetalles


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ucareapk.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleEstudiante(navController: NavHostController, padding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Botón de regreso
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
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
        Spacer(modifier = Modifier.height(16.dp))

        // Título decorado
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFD5E8C8))
        ) {

            Text(
                text = "Detalles",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6D6D6D),
                modifier = Modifier.padding(16.dp)

            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Datos del estudiante
        EstudianteInfo(navController)

        Spacer(modifier = Modifier.height(16.dp))

        // Historial de sesiones
        SesionHistorial()
    }
}

@Composable
fun EstudianteInfo(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD5E8C8), RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        // Foto y datos básicos
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.usericon), // Reemplaza con tu imagen
                contentDescription = "user icon",
                modifier = Modifier.size(64.dp),
                tint = Color.Unspecified // Asegúrate de que no tenga un tinte
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = "Julia Chavez", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = "18 años")
                Text(text = "juliachavez@email.com")
                Text(text = "Teléfono: 85058424")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Fechas de sesión
        Text(text = "Fechas de sesión: Lunes, Miércoles, Viernes", fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        // Notas
        Text(text = "Notas:", fontWeight = FontWeight.Bold)
        Text(text = "- Mejor manejo del estrés")
        Text(text = "- Continuar con técnicas de afrontamiento")
        Text(text = "- Preparar lista de prioridades")
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { navController.navigate("AgregarNota") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6D6D6D))
        ) {
            Text(text = "Agregar notas", color = Color.White)
        }
    }
}
@Composable
fun SesionHistorial() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Historial de sesiones",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(3) { index ->
                SesionCard(
                    titulo = when (index) {
                        0 -> "Manejo del estrés"
                        1 -> "Problemas académicos"
                        else -> "Dificultades familiares"
                    },
                    fecha = when (index) {
                        0 -> "01/11/2024"
                        1 -> "11/11/2024"
                        else -> "18/11/2024"
                    },
                    descripcion = when (index) {
                        0 -> "Se discutieron técnicas de relajación."
                        1 -> "El estudiante expresó preocupación por exámenes."
                        else -> "Se exploraron conflictos familiares."
                    },
                    duracion = when (index) {
                        0 -> "50 min"
                        1 -> "45 min"
                        else -> "60 min"
                    }
                )
            }
        }
    }
}
@Composable
fun SesionCard(titulo: String, fecha: String, descripcion: String, duracion: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFD5E8C8))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = titulo, fontWeight = FontWeight.Bold)
            Text(text = fecha, fontSize = 12.sp, color = Color.Gray)
            Text(text = descripcion, modifier = Modifier.padding(top = 8.dp))
            Text(text = "Duración: $duracion", fontSize = 12.sp, color = Color.Gray)
        }
    }
}