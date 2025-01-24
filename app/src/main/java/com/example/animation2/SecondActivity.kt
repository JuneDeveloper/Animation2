package com.example.animation2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animation2.model.Product
import com.example.animation2.utils.MyAdapterAdd
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SecondActivity : AppCompatActivity() {

    private val listProduct = Product.product
    private val listBasket = mutableListOf<Product>()

    private lateinit var toolbarTB:Toolbar
    private lateinit var recycleView:RecyclerView
    private lateinit var floatButtonBTN:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        init()

        addProduct()

        nextActivity()
    }

    private fun nextActivity() {
        val buttonAnim = AnimationUtils.loadAnimation(this,R.anim.float_button_move)
        floatButtonBTN.startAnimation(buttonAnim)
        floatButtonBTN.setOnClickListener {
            val intent = Intent(this,BasketActivity::class.java)
            intent.putExtra("basket",ArrayList(listBasket))
            startActivity(intent)
            finish()
        }
    }

    private fun addProduct() {
        val adapter = MyAdapterAdd(this,listProduct,listBasket)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = adapter
    }

    private fun init() {
        toolbarTB = findViewById(R.id.toolbarTB)
        setSupportActionBar(toolbarTB)
        recycleView = findViewById(R.id.recycleView)
        floatButtonBTN = findViewById(R.id.floatButtonBTN)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.exitItem -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}