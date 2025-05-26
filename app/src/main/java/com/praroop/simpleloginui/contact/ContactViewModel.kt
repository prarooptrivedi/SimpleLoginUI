package com.praroop.simpleloginui.contact

import android.content.Context
import android.provider.ContactsContract
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
class ContactViewModel:ViewModel() {
    var allContacts by mutableStateOf(listOf<Contact>())
        private set

    var selectedContacts by mutableStateOf(listOf<Contact>())
        private set

    fun loadContacts(context: Context){
        val contacts= mutableListOf<Contact>()
        val resolver=context.contentResolver
        val cursor=resolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,null,null,null
        )
        cursor?.use {
            val nameIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            val phoneIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
            while (it.moveToNext()) {
                val name = it.getString(nameIndex)
                val phone = it.getString(phoneIndex)
                contacts.add(Contact(name, phone))
            }
        }

        allContacts = contacts
    }
    fun updateSelection(contact: Contact, selected: Boolean) {
        allContacts = allContacts.map {
            if (it.phone == contact.phone) it.copy(isSelected = selected) else it
        }
    }

    fun saveSelected() {
        selectedContacts = allContacts.filter { it.isSelected }
    }
}