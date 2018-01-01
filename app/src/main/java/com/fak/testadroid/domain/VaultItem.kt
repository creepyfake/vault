package com.fak.testadroid.domain

/**
 * Created by fak on 31/12/2017.
 */
class VaultItem(val name: String, var type: VaultItemType, var value: String){

    private val fields : MutableList<VaultItemField> = mutableListOf()


    fun addField(field : VaultItemField){
        fields.add(field)
    }
    fun deleteField(field : VaultItemField){
        if(fields.contains(field))
            fields.remove(field)
    }
    fun deleteField(position: Int){
        if(fields.size> position)
            fields.removeAt(position)
    }
}


