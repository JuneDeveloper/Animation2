package com.example.animation2.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.animation2.R
import com.example.animation2.model.Product

class MyAdapterAdd(
    private val context: Context,
    private val products:MutableList<Product>,
    private val newList:MutableList<Product>)
    :RecyclerView.Adapter<MyAdapterAdd.ItemList>() {

    class ItemList(itemView:View):ViewHolder(itemView){
        val image:ImageView = itemView.findViewById(R.id.imageViewIV)
        val name:TextView = itemView.findViewById(R.id.nameProductTV)
        val weight:TextView = itemView.findViewById(R.id.weightProductTV)
        val price:TextView = itemView.findViewById(R.id.priceProductTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemList {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item,parent,false)
        return ItemList(itemView)
    }

    override fun onBindViewHolder(holder: ItemList, position: Int) {
        val product = products[position]
        holder.image.setImageResource(product.image)
        holder.name.text = product.name
        holder.weight.text = product.weight
        holder.price.text = product.price
        holder.itemView.setOnClickListener {
                AlertDialog.Builder(context)
                    .setTitle("Внимание!")
                    .setMessage("Добавить товар в корзину?")
                    .setCancelable(true)
                    .setNegativeButton("В корзину") { dialog, witch ->
                        newList.add(product)
                    }
                    .setPositiveButton("Отмена"){ dialog, witch ->
                        dialog.cancel()
                    }.create().show()
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }
}