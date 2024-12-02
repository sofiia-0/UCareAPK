package com.example.ucareapk.pantallasinicio

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.ucareapk.R
import com.example.ucareapk.ui.components.CustomTextField
import com.example.ucareapk.ui.theme.dmsansFamily

@Composable
fun PantallaNuevaContrasenia(navController: NavController, modifier: Modifier = Modifier) {
    var nuevaContrasenia by remember { mutableStateOf("") }
    var confirmarContrasenia by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 20.dp)
        ) {
            // Botón de regresar
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate("VerificarCodigo") }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.iconregresar), // Reemplaza con tu recurso
                    contentDescription = "Regresar",
                    tint = Color(0xFF715857),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Regresar",
                    color = Color(0xFF715857),
                    fontSize = 16.sp,
                    fontFamily = dmsansFamily,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(60.dp))

            // Texto principal
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color(0xFF715857), fontSize = 20.sp, fontWeight = FontWeight.Bold)) {
                        append("Recupera tu cuenta\n")
                    }
                    withStyle(style = SpanStyle(color = Color(0xFF9CA57B), fontSize = 20.sp, fontWeight = FontWeight.Bold)) {
                        append("UCare ☆(｡•‿‿•｡)")
                    }
                },
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Campo para la nueva contraseña
            CustomTextField(
                label = "Ingresa tu nueva contraseña",
                iconId = R.drawable.iconcontrasenia,
                contentDescription = "Nueva contraseña",
                text = nuevaContrasenia,
                onTextChanged = { nuevaContrasenia = it },
                isPassword = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFF5F5F5))
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Campo para confirmar la contraseña
            CustomTextField(
                label = "Confirma la contraseña",
                iconId = R.drawable.iconcontrasenia,
                contentDescription = "Confirmar contraseña",
                text = confirmarContrasenia,
                onTextChanged = { confirmarContrasenia = it },
                isPassword = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFF5F5F5))
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Botón de cambiar contraseña
            Button(
                onClick = {  navController.navigate("PantallaLogIn") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9CA57B)),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(
                    text = "Cambiar contraseña",
                    color = Color.White,
                    fontFamily = dmsansFamily,
                    fontSize = 16.sp
                )
            }
        }
    }
}