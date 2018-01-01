package com.fak.testadroid.domain

/**
 * Created by fak on 31/12/2017.
 */
class VaultContent{

    private val items: MutableList<VaultItem> = mutableListOf()

    fun addVaultItem(item: VaultItem){
        items.add(item)
    }

    fun getVaultItems(): List<VaultItem>{
        return items
    }

    fun getVaultItemByPos(position: Int):VaultItem {
        return items[position]
    }

    fun getVaultItemByName(n: String): List<VaultItem>{
        return items.filter { it.name == n }
    }

}