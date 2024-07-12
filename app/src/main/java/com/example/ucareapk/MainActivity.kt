package com.example.ucareapk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.ucareapk.pantallasinicio.PantallaHome
import com.example.ucareapk.pantallasinicio.PantallaSignUp
import com.example.ucareapk.ui.theme.UCareAPKTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UCareAPKTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaHome(modifier = Modifier.padding(innerPadding))
                }

            }
        }
    }
}

