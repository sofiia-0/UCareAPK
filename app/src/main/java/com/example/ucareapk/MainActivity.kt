package com.example.ucareapk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.ucareapk.pantallasinicio.PantallaSignUp
import com.example.ucareapk.ui.theme.UCareAPKTheme
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucareapk.pantallasActividad.PantallaActividad
import com.example.ucareapk.pantallasinicio.PantallaHome
import com.example.ucareapk.pantallasinicio.PantallaInicio
import com.example.ucareapk.pantallasinicio.PantallaSignUp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
                composable("home") { PantallaHome(navController) }
                composable("actividad") { PantallaActividad(navController, padding = PaddingValues()) }
            }
        }
    }
}