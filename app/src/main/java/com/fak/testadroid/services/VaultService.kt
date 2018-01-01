package com.fak.testadroid.services

import com.fak.testadroid.domain.VaultContent
import com.fak.testadroid.domain.VaultItem
import com.fak.testadroid.domain.VaultItemType

/**
 * Created by fak on 01/01/2018.
 */

interface IVaultService{
    fun loadVaultContent():VaultContent
    fun storeVaultConent(): Boolean
    fun addNewVaultItem(): Boolean
}

class VaultService : IVaultService{
    override fun loadVaultContent(): VaultContent {
        //TODO caricare da storage
        val vaultContent = VaultContent()

        vaultContent.addVaultItem(VaultItem("prima entry", VaultItemType.LOGIN,"pippo@pippi.it"))
        vaultContent.addVaultItem(VaultItem("prova password", VaultItemType.LOGIN,"miapassword"))
        vaultContent.addVaultItem(VaultItem("terza entry", VaultItemType.OTHER,"pippopluto"))

        return vaultContent
    }

    override fun storeVaultConent(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addNewVaultItem(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}