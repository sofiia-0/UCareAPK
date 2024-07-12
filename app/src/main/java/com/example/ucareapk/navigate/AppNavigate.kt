package com.example.ucareapk.navigate

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucareapk.pantallasActividad.CrearActividad
import com.example.ucareapk.pantallasActividad.PantallaActividad
import com.example.ucareapk.pantallasinicio.PantallaHome
import com.example.ucareapk.pantallasinicio.PantallaInicio
import com.example.ucareapk.pantallasinicio.PantallaSignUp

@Composable
fun AppNavigate() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") { PantallaActividad(navController = navController, padding = PaddingValues()) }
        composable("crearActividad") { CrearActividad(navController) }
    }

    NavHost(navController = navController, startDestination = "pantallaInicio") {
        composable("pantallaInicio") { PantallaInicio(onNavigateToSignUp = { navController.navigate("pantallaSignUp") }) }
        composable("pantallaSignUp") { PantallaSignUp() }
    }

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { PantallaHome(navController) }
        composable("actividad") { PantallaActividad(navController, padding = PaddingValues()) }
    }
}