package com.fak.testadroid.dagger

import android.app.Application
import android.content.Context
import com.fak.testadroid.services.IVaultService
import com.fak.testadroid.services.VaultService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * se le cose si fanno più complesse creare altri moduli con il grafo delle dipendenze delle
 * sottosezioni logiche
 */
@Module
class AppModule(private val app: Application) {

    /*
    * Dichiarazione di tutti i provider di dipendenze
    * */

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    fun provideVaultService(): IVaultService = VaultService()
}