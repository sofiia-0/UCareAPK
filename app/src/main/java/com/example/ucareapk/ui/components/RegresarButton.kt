package com.example.ucareapk.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucareapk.R
import com.example.ucareapk.ui.theme.dmsansFamily

@Composable
fun RegresarButton(modifier: Modifier = Modifier) {
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