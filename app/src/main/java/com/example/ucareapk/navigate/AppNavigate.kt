package com.example.ucareapk.navigate

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucareapk.PantallasDetalles.DetalleEstudiante
import com.example.ucareapk.PantallasDetalles.HistorialScreen
import com.example.ucareapk.PantallasDetalles.NotaScreen
import com.example.ucareapk.pantallasActividad.CrearActividad
import com.example.ucareapk.pantallasActividad.PantallaActividad
import com.example.ucareapk.pantallasRecordatorio.AgregarRecordatorio
import com.example.ucareapk.pantallasRecordatorio.PantallaRecordatorio
import com.example.ucareapk.pantallasRecordatorio.Recordatorios
import com.example.ucareapk.pantallasinicio.PantallaHome
import com.example.ucareapk.pantallasinicio.PantallaInicio
import com.example.ucareapk.pantallasinicio.PantallaSignUp

@Composable
fun AppNavigate() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "PantallaDetalle"
    ) {
        composable("PantallaDetalle") { DetalleEstudiante(navController, PaddingValues()) }
        composable("AgregarNota") { NotaScreen(navController)}
   }
   /* NavHost(navController, startDestination = "home") {
        composable("actividades") { PantallaActividad(navController = navController, padding = PaddingValues()) }
        composable("crearActividad") { CrearActividad(navController) }
    }*/

   /* NavHost(navController = navController, startDestination = "pantallaInicio") {
        composable("pantallaInicio") { PantallaInicio(onNavigateToSignUp = { navController.navigate("pantallaSignUp") }) }
        composable("pantallaSignUp") { PantallaSignUp(navController) }
        composable("pantallahome"){ PantallaHome(navController)}
        composable("actividades") { PantallaActividad(navController, padding = PaddingValues()) }
        composable("crearActividad") { CrearActividad(navController) }
        composable("recordatorios") { PantallaRecordatorio(navController = navController, padding = PaddingValues()) }
        composable("Recordatorio") { Recordatorios(navController) }
        composable("AgregarRecordatorio") { AgregarRecordatorio(navController) }
    }*/

    /*NavHost(navController = navController, startDestination = "home") {
        composable("home") { PantallaHome(navController) }
        composable("actividad") { PantallaActividad(navController, padding = PaddingValues()) }
    }*/

}