package com.fak.testadroid

import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import com.fak.testadroid.domain.VaultContent

class VaultItemListAdapter(private val vaultContent: VaultContent, private val context: Context) : ListAdapter {

    val STRING_VIEW_TYPE = 1


    override fun isEmpty(): Boolean {
        return !vaultContent.getVaultItems().isNotEmpty()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val item = vaultContent.getVaultItemByPos(position)
            val inflater = context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val rowView = inflater.inflate(R.layout.list_vault_item, parent, false)
            val valView = rowView.findViewById<TextView>(R.id.lst_item_val_name)

            valView.text = "${item.name}"
            /*
            when (item.type){
                VaultItemType.STRING -> return convertView!!
                VaultItemType.PASSWORD -> return convertView!!
            }
            */
            return rowView

    }

    override fun registerDataSetObserver(p0: DataSetObserver?) {

    }

    override fun getItemViewType(p0: Int): Int {
        return STRING_VIEW_TYPE
    }

    override fun getItem(p0: Int): Any {
        return vaultContent.getVaultItemByPos(p0)
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun isEnabled(p0: Int): Boolean {
        return true
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun areAllItemsEnabled(): Boolean {
        return true
    }

    override fun unregisterDataSetObserver(p0: DataSetObserver?) {
    }

    override fun getCount(): Int {
        return vaultContent.getVaultItems().size
    }

}