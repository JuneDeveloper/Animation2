package com.example.animation2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.animation2.model.Product
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Date

class CheckActivity : AppCompatActivity() {

    private lateinit var toolbarTB:Toolbar
    private lateinit var checkTV:TextView
    private var item = ""
    private var count = 1

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)

        init()

        writeCheck()
    }

    @SuppressLint("SetTextI18n", "NewApi")
    private fun writeCheck() {
        checkTV.text = "Кассовый чек\n " +
                "Минимаркет Лента\n " +
                "${LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))}\n" +
                "${LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))}\n\n"

        val checkList = intent.getSerializableExtra("check") as List<Product>
        if (checkList.isNotEmpty()) {
            for (i in checkList) {
                item = "$count.${i.name}\n${i.weight}\n${i.price.dropLast(3)}1 шт.\n\n"
                checkTV.append(item)
                count++
            }
        }else checkTV.text = "Вы не совершили покупок!\nЖдем Вас снова!"
    }

    private fun init() {
        toolbarTB = findViewById(R.id.toolbarTB)
        setSupportActionBar(toolbarTB)
        checkTV = findViewById(R.id.checkTV)
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