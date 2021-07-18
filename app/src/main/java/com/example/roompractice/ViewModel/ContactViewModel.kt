package com.example.roompractice.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roompractice.database.ContactDb
import com.example.roompractice.model.Contact
import com.example.roompractice.repository.ContactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ContactViewModel(application: Application): AndroidViewModel(application){
    val readAllData: LiveData<List<Contact>>
    private val repository: ContactRepository

    init{
        val contactDao= ContactDb.getDatabase(application).contactDao()
        repository = ContactRepository(contactDao)
        readAllData= repository.allData

    }
    fun addContact(contact: Contact){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addContact(contact)
        }

    }


}