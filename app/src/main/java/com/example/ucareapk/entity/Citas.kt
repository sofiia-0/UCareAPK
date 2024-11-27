package com.example.ucareapk.entity
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Citas (
    val id : Int,
    val estudianteNombre: String,
    val estudianteApellido: String,
    val fechaLimite: String ,
    val horaLimite: String,
    val estado: String
)