package com.example.ucareapk.entity
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Actividad (
    val id: Int ,
    val completada: Boolean ,
    val etiqueta: String ,
    val fechaLimite: String ,
    val horaLimite: String,
    val nombre: String
)