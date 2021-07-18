package com.example.roompractice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roompractice.R
import com.example.roompractice.ViewModel.ContactViewModel
import com.example.roompractice.adapters.recylerListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class list : Fragment() {

private lateinit var viewModel: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_list, container, false)
        //recyler view
        val rv= view.findViewById(R.id.recylerViewContact) as RecyclerView
        val adapter = recylerListAdapter()
        rv.adapter=adapter
        rv.layoutManager=LinearLayoutManager(requireContext())

        //model view
        viewModel=ViewModelProvider(this).get(ContactViewModel::class.java)
        viewModel.readAllData.observe(viewLifecycleOwner, Observer {contacts->
            adapter.setAllData(contacts)

        })


        view.findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener{
            findNavController().navigate(R.id.action_list_to_add2)
        }
        return view
    }


}