package com.example.ucareapk.pantallasinicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.ucareapk.R
import com.example.ucareapk.ui.theme.dmsansFamily

@Composable
fun PantallaHomePsicologo( modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .offset(y = (-50).dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(30.dp), // Espacio entre cada icono
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 95.dp, top = 764.dp, end = 95.dp) // Ajuste de los márgenes
        ) {
            Image(
                painter = painterResource(id = R.drawable.iconhome),
                contentDescription = "IconHome",
                modifier = Modifier
                    .size(21.dp)
                // la navegaciooon
            )
            Image(
                painter = painterResource(id = R.drawable.iconrecordatorio),
                contentDescription = "IconRecordatorio",
                modifier = Modifier.size(21.dp)

            )
            Image(
                painter = painterResource(id = R.drawable.iconactividades),
                contentDescription = "IconActividades",
                modifier = Modifier.size(21.dp)

            )
            Image(
                painter = painterResource(id = R.drawable.ajustes),
                contentDescription = "IconAjustes",
                modifier = Modifier.size(21.dp)
            )
        }
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 41.dp,
                    y = 217.dp)
                .requiredWidth(width = 336.dp)
                .requiredHeight(height = 220.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 173.dp,
                        y = 0.dp)
                    .requiredWidth(width = 163.dp)
                    .requiredHeight(height = 102.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 163.dp)
                        .requiredHeight(height = 102.dp)
                        .clip(shape = RoundedCornerShape(26.dp))
                        .background(color = Color(0xffe7ebf8)))
                Image(
                    painter = painterResource(id = R.drawable.iconproxrecordatorio),
                    contentDescription = "IconRecordatorio",
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 21.dp,
                            y = 20.dp)
                        .requiredWidth(width = 17.dp)
                        .requiredHeight(height = 19.dp)
                        .fillMaxSize()
                )
                Text(
                    text = "Próxima Cita",
                    color = Color(0xff868383),
                    style = TextStyle(
                        fontFamily = dmsansFamily,
                        fontSize = 12.sp),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 21.dp,
                            y = 56.dp)
                        .requiredWidth(width = 132.dp)
                        .requiredHeight(height = 13.dp))
                Text(
                    text = "Armando Alguera - 10:00 AM",
                    color = Color(0xff645e5f),
                    style = TextStyle(
                        fontSize = 9.sp,
                        fontFamily = dmsansFamily,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 21.dp,
                            y = 72.dp)
                        .requiredWidth(width = 122.dp)
                        .requiredHeight(height = 13.dp))
            }
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 173.dp,
                        y = 118.dp)
                    .requiredWidth(width = 163.dp)
                    .requiredHeight(height = 102.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 163.dp)
                        .requiredHeight(height = 102.dp)
                        .clip(shape = RoundedCornerShape(26.dp))
                        .background(color = Color(0xfffeeff9)))
                Text(
                    text = "Reportes",
                    color = Color(0xff898989),
                    style = TextStyle(
                        fontFamily = dmsansFamily,
                        fontSize = 13.sp),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 65.dp,
                            y = 45.dp)
                        .requiredWidth(width = 132.dp)
                        .requiredHeight(height = 13.dp))

                Image(
                    painter = painterResource(id = R.drawable.reporte),

                    contentDescription = "IconReporte",
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 21.dp, y = 25.dp)
                        .requiredWidth(width = 30.dp)
                        .requiredHeight(height = 48.dp)
                        .fillMaxSize()
                )
            }
            Box(
                modifier = Modifier
                    .requiredWidth(width = 160.dp)
                    .requiredHeight(height = 220.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 160.dp)
                        .requiredHeight(height = 220.dp)
                        .clip(shape = RoundedCornerShape(26.dp))
                        .background(color = Color(0xffdee4c9)))
                Image(
                    painter = painterResource(id = R.drawable.grafactcompl),
                    contentDescription = "GrafActCompl",
                    modifier = Modifier
                        .align(alignment = Alignment.TopCenter)
                        .offset(y = 45.dp)
                        .requiredWidth(width = 59.dp)
                        .requiredHeight(height = 66.dp)
                        .fillMaxSize()
                )
                Text(
                    text = "Citas",
                    color = Color(0xff645e5f),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = dmsansFamily,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 37.dp,
                            y = 148.dp)
                        .requiredWidth(width = 86.dp)
                        .requiredHeight(height = 16.dp))
                Text(
                    text = "completadas esta semana",
                    color = Color(0xff898989),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = dmsansFamily,
                        fontSize = 10.sp),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 19.dp,
                            y = 167.dp)
                        .requiredWidth(width = 122.dp)
                        .requiredHeight(height = 13.dp))
                Text(
                    text = "2    3    2    3",
                    color = Color(0xff9ca57b),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = dmsansFamily,
                        fontSize = 10.sp),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 45.dp,
                            y = 114.dp)
                        .requiredWidth(width = 71.dp)
                        .requiredHeight(height = 13.dp))
            }
        }
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 42.dp,
                    y = 460.dp)
                .requiredWidth(width = 338.dp)
                .requiredHeight(height = 277.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 0.dp,
                        y = 50.dp)
                    .requiredWidth(width = 338.dp)
                    .requiredHeight(height = 61.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 338.dp)
                        .requiredHeight(height = 61.dp)
                        .clip(shape = RoundedCornerShape(21.dp))
                        .background(color = Color(0xfff8f5f3)))
                Text(
                    text = "Armando Alguera",
                    color = Color.Black,
                    style = TextStyle(
                        fontFamily = dmsansFamily,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 63.dp,
                            y = 20.dp)
                        .requiredWidth(width = 146.dp)
                        .requiredHeight(height = 20.dp))
                Text(
                    text = "18/10/2024",
                    color = Color.Black,
                    textAlign = TextAlign.End,
                    style = TextStyle(
                        fontFamily = dmsansFamily,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 223.dp,
                            y = 11.dp)
                        .requiredWidth(width = 95.dp)
                        .requiredHeight(height = 20.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically))

                Text(
                    text = "10:00 AM",
                    color = Color(0xff898989),
                    textAlign = TextAlign.End,
                    style = TextStyle(
                        fontFamily = dmsansFamily,
                        fontSize = 12.sp),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 258.dp,
                            y = 36.dp)
                        .requiredWidth(width = 60.dp)
                        .requiredHeight(height = 16.dp)
                        .wrapContentHeight(align = Alignment.Bottom))
                Image(
                    painter = painterResource(id = R.drawable.persona),
                    contentDescription = "IconPersona",
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 22.dp, y = 17.dp)
                        .requiredWidth(width = 20.dp)
                        .requiredHeight(height = 28.dp)
                        .fillMaxSize()
                )
            }
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 0.dp,
                        y = 133.dp)
                    .requiredWidth(width = 338.dp)
                    .requiredHeight(height = 61.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 338.dp)
                        .requiredHeight(height = 61.dp)
                        .clip(shape = RoundedCornerShape(21.dp))
                        .background(color = Color(0xfff8f5f3)))
                Text(
                    text = "Rodrigo Paniagua",
                    color = Color.Black,
                    style = TextStyle(
                        fontFamily = dmsansFamily,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 63.dp,
                            y = 20.dp)
                        .requiredWidth(width = 158.dp)
                        .requiredHeight(height = 20.dp))
                Text(
                    text = "18/10/2024",
                    color = Color.Black,
                    textAlign = TextAlign.End,
                    style = TextStyle(
                        fontFamily = dmsansFamily,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 223.dp,
                            y = 11.dp)
                        .requiredWidth(width = 95.dp)
                        .requiredHeight(height = 20.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically))

                Text(
                    text = "1:00 PM",
                    color = Color(0xff898989),
                    textAlign = TextAlign.End,
                    style = TextStyle(
                        fontFamily = dmsansFamily,
                        fontSize = 12.sp),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 258.dp,
                            y = 36.dp)
                        .requiredWidth(width = 60.dp)
                        .requiredHeight(height = 16.dp)
                        .wrapContentHeight(align = Alignment.Bottom))
                Image(
                    painter = painterResource(id = R.drawable.persona),
                    contentDescription = "IconPersona",
                    modifier = Modifier
                        .requiredWidth(width = 20.dp)
                        .requiredHeight(height = 28.dp)
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 22.dp, y = 17.dp)
                        .fillMaxSize()
                )
            }
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 0.dp,
                        y = 216.dp)
                    .requiredWidth(width = 338.dp)
                    .requiredHeight(height = 61.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 338.dp)
                        .requiredHeight(height = 61.dp)
                        .clip(shape = RoundedCornerShape(21.dp))
                        .background(color = Color(0xfff8f5f3)))
                Text(
                    text = "Josue Cano",
                    color = Color.Black,
                    style = TextStyle(
                        fontFamily = dmsansFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 63.dp,
                            y = 20.dp)
                        .requiredWidth(width = 146.dp)
                        .requiredHeight(height = 20.dp))
                Text(
                    text = "19/10/2024",
                    color = Color.Black,
                    textAlign = TextAlign.End,
                    style = TextStyle(
                        fontFamily = dmsansFamily,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 223.dp,
                            y = 11.dp)
                        .requiredWidth(width = 95.dp)
                        .requiredHeight(height = 20.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically))

                Text(
                    text = "11:59 PM",
                    color = Color(0xff898989),
                    textAlign = TextAlign.End,
                    style = TextStyle(
                        fontFamily = dmsansFamily,
                        fontSize = 12.sp),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 258.dp,
                            y = 36.dp)
                        .requiredWidth(width = 60.dp)
                        .requiredHeight(height = 16.dp)
                        .wrapContentHeight(align = Alignment.Bottom))
                Image(
                    painter = painterResource(id = R.drawable.persona),
                    contentDescription = "IconPersona",
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 22.dp, y = 17.dp)
                        .requiredWidth(width = 20.dp)
                        .requiredHeight(height = 28.dp)
                        .fillMaxSize()
                )
            }
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 2.dp,
                        y = 0.dp)
                    .requiredWidth(width = 336.dp)
                    .requiredHeight(height = 25.dp)
            ) {
                Text(
                    text = "Ver todas",
                    color = Color.Black,
                    textAlign = TextAlign.End,
                    style = TextStyle(
                        fontFamily = dmsansFamily,
                        fontSize = 18.sp),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 245.dp,
                            y = 6.dp)
                        .requiredWidth(width = 91.dp)
                        .requiredHeight(height = 19.dp))
                Text(
                    text = "Citas de hoy",
                    color = Color.Black,
                    style = TextStyle(
                        fontFamily = dmsansFamily,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .requiredWidth(width = 190.dp)
                        .requiredHeight(height = 25.dp))
            }
        }
        Image(
            painter = painterResource(id = R.drawable.botonopciones),
            contentDescription = "BotonOpciones",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 341.dp,
                    y = 82.dp)
                .requiredWidth(width = 32.dp)
                .requiredHeight(height = 30.dp))
        Image(
            painter = painterResource(id = R.drawable.usericon),
            contentDescription = "UserIcon",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 43.dp,
                    y = 78.dp)
                .requiredWidth(width = 53.dp)
                .requiredHeight(height = 52.dp)
                .clip(shape = RoundedCornerShape(20.dp)))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 41.dp,
                    y = 149.dp)
                .requiredWidth(width = 216.dp)
                .requiredHeight(height = 50.dp)
        ) {
            Text(
                text = "¡Bienvenido de vuelta! ☆( ˶ᵔ ᵕ ᵔ˶ )",
                color = Color(0xff898989),
                style = TextStyle(
                    fontFamily = dmsansFamily,
                    fontSize = 12.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 2.dp,
                        y = 36.dp)
                    .requiredWidth(width = 214.dp)
                    .requiredHeight(height = 14.dp))
            Text(
                text = "Hola!",
                color = Color.Black,
                style = TextStyle(
                    fontFamily = dmsansFamily,
                    fontSize = 25.sp),
                modifier = Modifier
                    .requiredWidth(width = 139.dp)
                    .requiredHeight(height = 25.dp))
        }
        Image(
            painter = painterResource(id = R.drawable.separacionlinea),
            contentDescription = "SeparacionLinea",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 21.dp,
                    y = 761.dp)
                .requiredWidth(width = 376.dp)
                .requiredHeight(height = 1.dp))
    }
}
/*
@Preview
@Composable
private fun PantallaHomePreview() {
    PantallaHome(Modifier)
}*/


