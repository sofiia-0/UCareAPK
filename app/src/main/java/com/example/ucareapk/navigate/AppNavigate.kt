package com.example.ucareapk.navigate

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucareapk.pantallaEstadoAnimo.PantallaEstadoAnimo
import com.example.ucareapk.pantallaEstadoAnimo.RegistroAnimo
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
    //no se comentaria val navController
    val navController = rememberNavController()
    //Ejemplo de como hacer la navegacion
    /*--------------------------------------------------------------------
    Primero empieza con "NavHost", colocas el navController (la val) y luego el origen del distino
    ese nombre puede ser cualquiera que desees, es importante que tu primera ruta sea siempre el origen del destino
    (como se observa abajo), luego de colocar el composable("nombre_de_ruta") entre llaves
    se coloca el nombre de la funcion que tiene la pantalla con su respectivo navController y si es necesario PaddingValues
    es importante aclarar que si tiene una navegacion a una funcion extra no coloques el paddinfvalues, por que si no la app se cierra
    (puedes guiarte del ejemplo de abajo)
     ---------------------------------------------------------------------*/
    /*NavHost(navController = navController, startDestination = "PantallaDetalle") {
        composable("PantallaDetalle") { DetalleEstudiante(navController, PaddingValues()) }
        composable("AgregarNota") { NotaScreen(navController)}
   }*/

    NavHost(navController = navController, startDestination = "pantallaInicio") {
        // Pantalla de inicio de sesion
        composable("pantallaInicio") { PantallaInicio(onNavigateToSignUp = { navController.navigate("pantallaSignUp") }) }
        // Pantalla de registro de usuario
        composable("pantallaSignUp") { PantallaSignUp(navController) }
        // Home para estudiantes
        composable("pantallahome"){ PantallaHome(navController)}
        //  Pantalla actividades
        composable("actividades") { PantallaActividad(navController, padding = PaddingValues()) }
        // Crear actividad
        composable("crearActividad") { CrearActividad(navController) }
        // Pantalla de recordatorios
        composable("recordatorios") { PantallaRecordatorio(navController = navController, padding = PaddingValues()) }
        // Calendario con los recordatorios
        composable("Recordatorio") { Recordatorios(navController) }
        // Agregar un recordatorio
        composable("AgregarRecordatorio") { AgregarRecordatorio(navController) }
        // Pantalla de Estados de animo
        composable("estadoanimo") { PantallaEstadoAnimo(navController = navController, padding = PaddingValues())  }
        //Nuevo Estado de animo
        composable("NuevoAnimo") { RegistroAnimo(navController) }
    }

    /*NavHost(navController = navController, startDestination = "home") {
        composable("home") { PantallaHome(navController) }
        composable("actividad") { PantallaActividad(navController, padding = PaddingValues()) }
    }*/

}