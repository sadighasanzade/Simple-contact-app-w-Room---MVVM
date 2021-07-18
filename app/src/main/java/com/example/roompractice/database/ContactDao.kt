package com.example.roompractice.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roompractice.model.Contact

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addContact(contact:Contact)

    @Query("SELECT * FROM contact_table ORDER by id ASC")
    fun readAllContacts():LiveData<List<Contact>>
}