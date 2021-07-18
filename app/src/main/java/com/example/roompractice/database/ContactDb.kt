package com.example.roompractice.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roompractice.model.Contact
import android.content.Context
import androidx.room.Room

@Database(entities = [Contact::class],version = 1,exportSchema = false)
abstract class ContactDb : RoomDatabase() {
    abstract fun contactDao():ContactDao

    companion object{
        @Volatile
        private var INSTANCE: ContactDb? = null
        fun getDatabase(context: Context): ContactDb{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDb::class.java,
                    "contact_table"
                ).build()
                INSTANCE=instance
                return instance

            }

        }
    }
}