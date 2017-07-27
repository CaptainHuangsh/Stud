package com.example.owen.stud.kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.owen.stud.MainActivity
import com.example.owen.stud.R

/**
 * Created by loopeer on 2017/7/26.
 */
class KotlinMain : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_main)
        init()
    }

    fun init() {
        findViewById(R.id.kotlin_btn2).setOnClickListener(View.OnClickListener {
            Toast.makeText(
                    this, "ooo", Toast.LENGTH_SHORT).show()
        })
        findViewById(R.id.kotlin_btn1).setOnClickListener(View.OnClickListener {
            var mIntent = Intent(this@KotlinMain,MainActivity::class.java)
            startActivity(mIntent)
            Log.d(KotlinMain::class.simpleName,"asddasdsda")
        })
    }
}