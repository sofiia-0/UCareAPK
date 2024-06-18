package com.example.ucareapk.pruebas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucareapk.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GrupoUsuario(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        label = {
            Text(
                text = "Usuario",
                color = Color(0xff6c5352).copy(alpha = 0.6f),
                style = TextStyle(fontSize = 17.sp),
                modifier = Modifier.requiredHeight(height = 21.dp)
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.iconusuario),
                contentDescription = "iconusuario",
                modifier = Modifier.requiredSize(size = 20.dp)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xfff2f1ef)
        ),
        modifier = modifier
            .requiredWidth(width = 272.dp)
            .requiredHeight(height = 49.dp)
    )
}

@Preview(widthDp = 272, heightDp = 49)
@Composable
private fun GrupoUsuarioPreview() {
    GrupoUsuario(Modifier)
}
