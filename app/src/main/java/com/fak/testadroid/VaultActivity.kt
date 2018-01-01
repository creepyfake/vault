package com.fak.testadroid

import android.app.Application
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import com.fak.testadroid.domain.VaultItem

import kotlinx.android.synthetic.main.activity_vault.*
import com.fak.testadroid.dagger.AppComponent
import com.fak.testadroid.dagger.AppModule
import com.fak.testadroid.dagger.DaggerAppComponent
import com.fak.testadroid.services.IVaultService
import javax.inject.Inject


class VaultActivity : AppCompatActivity(){

    //Questo andrebbe nella classe application se l'avessi
    private fun initDagger(app: Application): AppComponent =
            DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build()
    lateinit var vaultAppComponent: AppComponent
    //dipendenza iniettata
    @Inject lateinit var service: IVaultService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDependencyInjection()

        setContentView(R.layout.activity_vault)

        initListView()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    private fun initDependencyInjection() {
        //crea il grafo delle dipendenze
        vaultAppComponent = initDagger(this.application)
        // richiede l'iniezione delle dipendenze
        vaultAppComponent.inject(this)
    }

    private fun initListView() {
        val listView = findViewById<ListView>(R.id.list_main)
        listView.adapter = VaultItemListAdapter(service.loadVaultContent(), this)
        listView.setOnItemClickListener { adapterView, view, i, _ ->
            val item = adapterView.getItemAtPosition(i) as VaultItem

            Snackbar.make(view, "Vault item ${item.name}", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_vault, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.action_exit -> exitVault()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun exitVault(): Boolean{
        return true
    }

    override fun onRestart() {
        super.onRestart()
        System.out.println("onRestart")
    }

    override fun onResume() {
        super.onResume()
        System.out.println("onResume")
    }

    override fun onStop() {
        super.onStop()
        System.out.println("onStop")
    }
    override fun onPause() {
        super.onPause()
        System.out.println("onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        System.out.println("onDestroy")
    }
}

