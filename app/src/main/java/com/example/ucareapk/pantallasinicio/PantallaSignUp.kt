package com.example.ucareapk.pantallasinicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.example.ucareapk.R
import com.example.ucareapk.ui.components.CustomTextField
import com.example.ucareapk.ui.components.GrupoRegresar
import com.example.ucareapk.ui.theme.dmsansFamily

@Composable
fun PantallaSignUp(modifier: Modifier = Modifier) {
    var usuario by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .requiredWidth(400.dp)
            .requiredHeight(800.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .requiredWidth(210.dp)
                    .requiredHeight(250.dp)
            ) {
                GrupoRegresar()
                Image(
                    painter = painterResource(id = R.drawable.pandaicon),
                    contentDescription = "Panda",
                    modifier = Modifier
                        .align(alignment = Alignment.BottomCenter)
                        .requiredWidth(width = 209.dp)
                        .requiredHeight(height = 190.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.holabubble),
                    contentDescription = "BubbleTextHola",
                    modifier = Modifier
                        .align(alignment = Alignment.BottomCenter)
                        .offset(x = 49.5.dp, y = (-150).dp)
                        .requiredWidth(width = 113.dp)
                        .requiredHeight(height = 54.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp)) // Espacio entre pandaicon y el texto

            Text(
                textAlign = TextAlign.Center,
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xff715857),
                            fontSize = 20.sp,
                            fontFamily = dmsansFamily,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("Creá tu cuenta en \n")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xff9ca57b),
                            fontSize = 20.sp,
                            fontFamily = dmsansFamily,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("UCare")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xff715857),
                            fontSize = 20.sp,
                            fontFamily = dmsansFamily,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(" ヾ(๑•｡•๑)◞ • *✰")
                    }
                },
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(bottom = 20.dp)
            )

            Box(
                modifier = Modifier
                    .requiredWidth(273.dp)
                    .requiredHeight(189.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CustomTextField(
                        label = "Usuario",
                        iconId = R.drawable.iconusuario,
                        contentDescription = "iconusuario",
                        text = usuario,
                        onTextChanged = { usuario = it }
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    CustomTextField(
                        label = "Correo",
                        iconId = R.drawable.iconcorreo,
                        contentDescription = "iconcorreo",
                        text = correo,
                        onTextChanged = { correo = it }
                    )
                    Spacer(modifier = Modifier.height(28.dp))

                    CustomTextField(
                        label = "Contraseña",
                        iconId = R.drawable.iconcontrasenia,
                        contentDescription = "iconcontrasenia",
                        text = contraseña,
                        onTextChanged = { contraseña = it },
                        isPassword = true,
                        passwordVisible = passwordVisible,
                        onPasswordVisibilityChanged = { passwordVisible = !passwordVisible }
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp)) // Espacio entre los TextField y el botón "Continuar"

            Box(
                modifier = Modifier
                    .requiredWidth(193.dp)
                    .requiredHeight(47.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(193.dp)
                        .requiredHeight(47.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(color = Color(0xff9ca57b))
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = (-5).dp)
                        .requiredWidth(38.dp)
                        .requiredHeight(37.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(color = Color(0xff353c1c))
                )
                Image(
                    painter = painterResource(id = R.drawable.iconflechacontinuar),
                    contentDescription = "iconflechacontinuar",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = (-14).dp, y = 1.dp)
                        .requiredSize(20.dp)
                )
                Text(
                    text = "Continuar ",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = dmsansFamily,
                        fontSize = 17.sp
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .offset(x = 19.dp, y = 1.dp)
                        .requiredWidth(124.dp)
                        .requiredHeight(24.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun PantallaSignUpPreview() {
    PantallaSignUp(Modifier)
}
