package com.example.cse225_part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class CustomExtendingViews : AppCompatActivity() {
//    lateinit var customFan: CustomFan //For CustomFan
    lateinit var customDrawing: CustomDrawing
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_extending_views)

//        customFan = CustomFan(this)
//        setContentView(customFan) //For CustomFan

//        customDrawing = CustomDrawing(this)
//        setContentView(customDrawing) //For CustomDrawing

        val clearBtn = findViewById<Button>(R.id.clear)
        customDrawing = findViewById<View>(R.id.drawArea) as CustomDrawing
        clearBtn.setOnClickListener{
            customDrawing.clear()
        }


    }

}