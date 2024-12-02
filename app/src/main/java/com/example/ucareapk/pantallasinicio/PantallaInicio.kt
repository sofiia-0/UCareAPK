package com.example.ucareapk.pantallasinicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
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
fun PantallaInicio(
    onNavigateToSignUp: () -> Unit,
    onNavigateToLogIn: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .requiredWidth(273.dp)
                .requiredHeight(521.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 1.dp, y = 417.dp)
                    .requiredWidth(272.dp)
                    .requiredHeight(104.dp)
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .offset(y = (-27.5).dp)
                        .requiredWidth(272.dp)
                        .requiredHeight(49.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xff9ca57b))
                )
                Text(
                    text = "Registrarme",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontFamily = dmsansFamily
                    ),
                    modifier = Modifier
                        .align(Alignment.Center)
                        .offset(y = (-27).dp)
                        .clickable { onNavigateToSignUp() }
                )
                Text(
                    text = "Iniciar sesión",
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontFamily = dmsansFamily
                    ),
                    modifier = Modifier
                        .align(Alignment.Center)
                        .offset(y = 40.dp)
                        .clickable { onNavigateToLogIn() }
                )
            }
            Box(
                modifier = Modifier
                    .requiredWidth(272.dp)
                    .requiredHeight(350.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pandaicon),
                    contentDescription = "Panda",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .offset(y = 10.dp)
                        .requiredWidth(209.dp)
                        .requiredHeight(190.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.holabubble),
                    contentDescription = "BubbleTextHola",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .offset(x = 49.5.dp, y = (-77.83).dp)
                        .requiredWidth(113.dp)
                        .requiredHeight(54.dp)
                )
                Text(
                    textAlign = TextAlign.Center,
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color(0xff5a4d4b), fontSize = 22.sp, fontWeight = FontWeight.Bold)) {
                            append("Un sistema de cuidado ")
                        }
                        withStyle(style = SpanStyle(color = Color(0xff9ca57b), fontSize = 22.sp, fontWeight = FontWeight.Bold)) {
                            append("para tu ")
                        }
                        withStyle(style = SpanStyle(color = Color(0xff5a4d4b), fontSize = 22.sp, fontWeight = FontWeight.Bold)) {
                            append("bienestar")
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.Center)
                        .offset(y = 104.dp)
                        .requiredWidth(272.dp)
                        .requiredHeight(60.dp)
                )
            }
        }
    }
}

