package com.fak.testadroid.dagger

import com.fak.testadroid.VaultActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by fak on 01/01/2018.
 */
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent{
    /*
    * Dichiarazione di tutti i target di dependency injection
    * */
    fun inject(target: VaultActivity)
}