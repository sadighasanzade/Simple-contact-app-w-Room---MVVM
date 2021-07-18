package com.example.roompractice.repository

import androidx.lifecycle.LiveData
import com.example.roompractice.database.ContactDao
import com.example.roompractice.model.Contact

class ContactRepository(private val contactAO:ContactDao) {
    val allData:LiveData<List<Contact>> = contactAO.readAllContacts()

    suspend fun addContact(contact: Contact){
        contactAO.addContact(contact)
    }
}