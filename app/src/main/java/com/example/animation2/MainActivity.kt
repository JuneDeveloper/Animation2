package com.example.animation2

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var linearLL:LinearLayout
    private lateinit var textMainTV:TextView
    private lateinit var imageMainIV:ImageView
    private lateinit var beginBuyBTN:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        anim()

        nextActivity()
    }

    private fun nextActivity() {
        beginBuyBTN.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun init() {
        linearLL = findViewById(R.id.linearLL)
        textMainTV = findViewById(R.id.textMainTV)
        imageMainIV = findViewById(R.id.imageMainIV)
        beginBuyBTN = findViewById(R.id.beginBuyBTN)
    }

    private fun anim(){
        val animation:AnimationDrawable = linearLL.background as AnimationDrawable
        animation.apply {
            setExitFadeDuration(2000)
            start()
        }
        val textAnim = AnimationUtils.loadAnimation(this,R.anim.text_main_move)
        val imageAnim = AnimationUtils.loadAnimation(this,R.anim.image_main_move)
        textMainTV.startAnimation(textAnim)
        beginBuyBTN.startAnimation(textAnim)
        imageMainIV.startAnimation(imageAnim)
    }
}