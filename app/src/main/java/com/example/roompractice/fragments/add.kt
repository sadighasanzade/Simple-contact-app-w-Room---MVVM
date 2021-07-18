package com.example.roompractice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roompractice.R
import com.example.roompractice.ViewModel.ContactViewModel
import com.example.roompractice.model.Contact


class add : Fragment() {
    private lateinit var viewModel: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add, container, false)
        viewModel= ViewModelProvider(this).get(ContactViewModel::class.java)
        view.findViewById<Button>(R.id.addBtn).setOnClickListener{
            val fname:String = view.findViewById<EditText>(R.id.fullName).text.toString()
            val mail:String = view.findViewById<EditText>(R.id.mail).text.toString()
            val number:String = view.findViewById<EditText>(R.id.Number).text.toString()

            if(fname.isEmpty() || mail.isEmpty() || number.isEmpty()){
                Toast.makeText(requireContext(), "Empty fields are not allowed", Toast.LENGTH_SHORT).show()
            }else{
                val contact: Contact = Contact(fname,mail,number,0)
                viewModel.addContact(contact)
                Toast.makeText(requireContext(), "Contact added Successfully", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_add2_to_list)
            }
        }

        return view
    }



}