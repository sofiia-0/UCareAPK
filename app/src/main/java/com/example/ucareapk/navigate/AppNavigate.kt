package com.example.ucareapk.navigate

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucareapk.PantallasDetalles.DetalleEstudiante
import com.example.ucareapk.PantallasDetalles.HistorialScreen
import com.example.ucareapk.PantallasDetalles.NotaScreen
import com.example.ucareapk.pantallaCitas.CitasEdicion
import com.example.ucareapk.pantallaCitas.CitasPsicologo
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
    //no comentareen la variable navController
    val navController = rememberNavController()
    //--------------------------------------------------------
    //ejemplo de como se hace una navegacion
    //la pantalla "principal" necesita un navcontroller y si es necesario los padding values
    //si necesita una navegacion no es necesario implementar padding values, en caso contrario la aplicacion se cerrara
    //----------------------------------------------------------
    NavHost(navController = navController, startDestination = "PantallaDetalle") {
        composable("PantallaDetalle") { CitasPsicologo(navController, PaddingValues()) }
        composable("EdicionCitas") { CitasEdicion(navController) }
   }

    /*NavHost(navController = navController, startDestination = "pantallaInicio") {
        composable("pantallaInicio") { PantallaInicio(onNavigateToSignUp = { navController.navigate("pantallaSignUp") }) }
        composable("pantallaSignUp") { PantallaSignUp(navController) }
        composable("pantallahome"){ PantallaHome(navController)}
        composable("actividades") { PantallaActividad(navController, padding = PaddingValues()) }
        composable("crearActividad") { CrearActividad(navController) }
        composable("recordatorios") { PantallaRecordatorio(navController = navController, padding = PaddingValues()) }
        composable("Recordatorio") { Recordatorios(navController) }
        composable("AgregarRecordatorio") { AgregarRecordatorio(navController) }
    }*/

}