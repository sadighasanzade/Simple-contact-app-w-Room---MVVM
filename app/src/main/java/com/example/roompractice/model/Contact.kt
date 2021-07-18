package com.example.roompractice.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_table")
data class Contact(
    val name:String,
    val mail:String,
    val number:String,
    @PrimaryKey(autoGenerate = true)
    val id:Int

)