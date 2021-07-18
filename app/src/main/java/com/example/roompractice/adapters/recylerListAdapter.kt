package com.example.roompractice.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roompractice.R
import com.example.roompractice.model.Contact

class recylerListAdapter: RecyclerView.Adapter<recylerListAdapter.ContactHolder>() {
    private var contactList= emptyList<Contact>()

    class ContactHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        return ContactHolder(LayoutInflater.from(parent.context).inflate(R.layout.single_contact,parent,false))
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {

        val currentItem:Contact = contactList[position]
        holder.itemView.findViewById<TextView>(R.id.num).text= currentItem.number.toString()
        holder.itemView.findViewById<TextView>(R.id.fullnameSingle).text= currentItem.name.toString()


    }
    fun setAllData(contacts: List<Contact>){
        this.contactList=contacts
        notifyDataSetChanged()

    }
    override fun getItemCount(): Int {
        return contactList.size
    }
}