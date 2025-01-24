package com.example.animation2

import android.annotation.SuppressLint
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
import com.example.animation2.utils.MyAdapterRemove
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BasketActivity : AppCompatActivity() {

    private var basketList = mutableListOf<Product>()

    private lateinit var toolbarTB:Toolbar
    private lateinit var recycleView:RecyclerView
    private lateinit var floatButtonBTN:FloatingActionButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)

        init()

        basket()

        nextActivity()
    }

    private fun nextActivity() {
        val buttonAnim = AnimationUtils.loadAnimation(this,R.anim.float_button_move)
        floatButtonBTN.startAnimation(buttonAnim)
        floatButtonBTN.setOnClickListener {
            val intent = Intent(this, CheckActivity::class.java)
            intent.putExtra("check",ArrayList(basketList))
            startActivity(intent)
            finish()
        }
    }

    private fun basket() {
        basketList = intent.getSerializableExtra("basket") as MutableList<Product>
        val adapter = MyAdapterRemove(this,basketList)
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