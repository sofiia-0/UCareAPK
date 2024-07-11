package com.example.ucareapk.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucareapk.ui.theme.dmsansFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    label: String,
    iconId: Int,
    contentDescription: String,
    text: String,
    onTextChanged: (String) -> Unit
) {
    TextField(
        value = text,
        onValueChange = onTextChanged,
        label = {
            Text(
                text = label,
                color = Color(0xff6c5352).copy(alpha = 0.6f),
                style = TextStyle(fontSize = 14.sp),
                fontFamily = dmsansFamily,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.requiredHeight(16.dp)
            )
        },
        leadingIcon = {
            Image(
                painter = painterResource(id = iconId),
                contentDescription = contentDescription,
                modifier = Modifier.requiredSize(20.dp)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xfff2f1ef),
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        textStyle = TextStyle(fontFamily = dmsansFamily),
        modifier = modifier
            .requiredWidth(300.dp)  // Ajusta el ancho según tu preferencia
            .requiredHeight(60.dp)  // Ajusta la altura según tu preferencia
            .clip(shape = RoundedCornerShape(16.dp))
            .border(
                border = BorderStroke(1.dp, Color(0xfff2f1ef)),
                shape = RoundedCornerShape(16.dp)
            )
    )
}

