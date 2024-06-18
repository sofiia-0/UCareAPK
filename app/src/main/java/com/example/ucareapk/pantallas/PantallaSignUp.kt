package com.example.ucareapk.pantallas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
import com.example.ucareapk.ui.theme.dmsansFamily

@Composable
fun PantallaSignUp(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
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
            )

            {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CustomTextField(iconId = R.drawable.iconusuario, contentDescription = "iconusuario")
                    Spacer(modifier = Modifier.height(25.dp))
                    CustomTextField(iconId = R.drawable.iconcorreo, contentDescription = "iconcorreo")
                    Spacer(modifier = Modifier.height(25.dp))
                    CustomTextField(iconId = R.drawable.iconcontrasenia, contentDescription = "iconcontrasenia")
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
                        fontFamily = dmsansFamily
                        ,fontSize = 17.sp),
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(iconId: Int, contentDescription: String) {
    Box(
        modifier = Modifier
            .requiredWidth(272.dp)
            .requiredHeight(49.dp)
    ) {
        Box(
            modifier = Modifier
                .requiredWidth(272.dp)
                .requiredHeight(49.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .background(color = Color(0xfff2f1ef))  // Color de fondo personalizado
                .border(
                    border = BorderStroke(1.dp, Color(0xff9ca57b)),  // Color y grosor del borde
                    shape = RoundedCornerShape(16.dp)
                )
        )
        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Image(
                    painter = painterResource(id = iconId),
                    contentDescription = contentDescription,
                    modifier = Modifier.requiredSize(20.dp)
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xfff2f1ef),  // Color de fondo del TextField
                cursorColor = Color.Black,  // Color del cursor
                focusedIndicatorColor = Color.Transparent,  // Color del indicador cuando está enfocado
                unfocusedIndicatorColor = Color.Transparent  // Color del indicador cuando no está enfocado
            ),
            textStyle = TextStyle(fontFamily = dmsansFamily),
            modifier = Modifier
                .align(Alignment.Center)
                .requiredWidth(272.dp)
                .requiredHeight(49.dp)
                .clip(shape = RoundedCornerShape(16.dp))
        )
    }
}

@Composable
fun GrupoRegresar(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .requiredWidth(56.dp)
    )
    {
        Box(
            modifier = modifier
                .requiredWidth(width = 120.dp)
                .requiredHeight(height = 26.dp)
            , contentAlignment = Alignment.TopStart
        ) {
            Text(
                text = "Regresar",
                color = Color(0xff715857),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = dmsansFamily,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .align(alignment = Alignment.TopEnd)
            )
            Image(
                painter = painterResource(id = R.drawable.iconregresar),
                contentDescription = "iconregresar",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .requiredSize(26.dp)
            )
        }
    }
}



@Preview
@Composable
private fun PantallaSignUpPreview() {
    PantallaSignUp(Modifier)
}
