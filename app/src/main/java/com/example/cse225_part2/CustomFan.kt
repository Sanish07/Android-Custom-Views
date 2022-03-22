package com.example.cse225_part2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class CustomFan(context:Context?) : View(context) {
    lateinit var p:Paint
    var x = 100

    fun init(){
        p = Paint()
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(Color.RED)
        p.color = Color.YELLOW
        canvas.drawRect(100f,100f,500f,500f,p)
        p.color = Color.WHITE
        canvas.drawArc(500f,500f,800f,800f,(x).toFloat(),30f,true,p)
        canvas.drawArc(500f,500f,800f,800f,(x+90).toFloat(),30f,true,p)
        canvas.drawArc(500f,500f,800f,800f,(x+180).toFloat(),30f,true,p)
        canvas.drawArc(500f,500f,800f,800f,(x+270).toFloat(),30f,true,p)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        for(i in 0..50000){
            when(event.action){
                MotionEvent.ACTION_DOWN -> startFan()
                MotionEvent.ACTION_UP -> stopFan()
            }
        }
        return true
    }

    fun stopFan(){}
    fun startFan(){
        x = x + 5
        invalidate() //invalidate() means redraw on screen and results to a call of the view's onDraw() method
    }

    init {
        init()
    }

}