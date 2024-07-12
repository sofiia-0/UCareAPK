package com.example.ucareapk.pantallasinicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
fun PantallaInicio(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .requiredWidth(width = 273.dp)
                .requiredHeight(height = 521.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 1.dp,
                        y = 417.dp)
                    .requiredWidth(width = 272.dp)
                    .requiredHeight(height = 104.dp)
            ) {
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .offset(x = 0.dp,
                            y = (-27.5).dp)
                        .requiredWidth(width = 272.dp)
                        .requiredHeight(height = 49.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(color = Color(0xff9ca57b)))
                Text(
                    text = "Registrarme",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontFamily = dmsansFamily),
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .offset(x = 0.5.dp,
                            y = (-27).dp)
                        .requiredWidth(width = 101.dp)
                        .requiredHeight(height = 24.dp))
                Text(
                    text = "Iniciar sesión",
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontFamily = dmsansFamily),
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .offset(x = (-2).dp,
                            y = 40.dp)
                        .requiredWidth(width = 204.dp)
                        .requiredHeight(height = 24.dp))
            }
            Box(
                modifier = Modifier
                    .requiredWidth(width = 272.dp)
                    .requiredHeight(height = 350.dp)
            ) {
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .offset(x = (-16).dp,
                            y = 169.5.dp)
                        .requiredWidth(width = 12.dp)
                        .requiredHeight(height = 11.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(color = Color(0xff9ca57b)))
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .offset(x = 10.dp,
                            y = 169.5.dp)
                        .requiredWidth(width = 28.dp)
                        .requiredHeight(height = 11.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(brush = Brush.linearGradient(
                            0f to Color(0xffd2d8bc),
                            1f to Color(0xffadb882),
                            start = Offset(14f, 0f),
                            end = Offset(14f, 11f))))
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 23.dp,
                            y = 0.dp)
                        .requiredWidth(width = 212.dp)
                        .requiredHeight(height = 210.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pandaicon),
                        contentDescription = "Panda",
                        modifier = Modifier
                            .align(alignment = Alignment.Center)
                            .offset(x = (-1.5).dp,
                                y = 10.dp)
                            .requiredWidth(width = 209.dp)
                            .requiredHeight(height = 190.dp))
                    Image(
                        painter = painterResource(id = R.drawable.holabubble),
                        contentDescription = "BubbleTextHola",
                        modifier = Modifier
                            .align(alignment = Alignment.Center)
                            .offset(x = 49.5.dp,
                                y = (-77.83333396911621).dp)
                            .requiredWidth(width = 113.dp)
                            .requiredHeight(height = 54.dp))
                }
                Text(
                    textAlign = TextAlign.Center,
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(
                            color = Color(0xff5a4d4b),
                            fontSize = 22.sp,
                            fontFamily = dmsansFamily,
                            fontWeight = FontWeight.Bold)
                        ) {append("Un sistema de cuidado ")}
                        withStyle(style = SpanStyle(
                            color = Color(0xff9ca57b),
                            fontSize = 22.sp,
                            fontFamily = dmsansFamily,
                            fontWeight = FontWeight.Bold)) {append("para tu ")}
                        withStyle(style = SpanStyle(
                            color = Color(0xff5a4d4b),
                            fontSize = 22.sp,
                            fontFamily = dmsansFamily,
                            fontWeight = FontWeight.Bold)) {append("bienestar")}},
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .offset(x = 0.dp,
                            y = 104.dp)
                        .requiredWidth(width = 272.dp)
                        .requiredHeight(height = 60.dp))
            }
        }
    }
}

@Preview
@Composable
private fun PantallaInicioPreview() {
    PantallaInicio(Modifier)
}
