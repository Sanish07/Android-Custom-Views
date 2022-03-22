package com.example.cse225_part2

import android.content.Context
import android.content.res.Resources
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.res.getStringOrThrow

class CustomEditText(context: Context,attrs:AttributeSet?) : AppCompatEditText(context, attrs) {

    private var setHint:String ?= null
    private var setColor = false
    private var allCapital = false
    private var textStyle:String ?= null

    var darkButton : Drawable?= null
    var lightButton : Drawable?= null

    fun init(){
        darkButton = ResourcesCompat.getDrawable(resources, R.drawable.ic_clear_black_24dp,null)
        lightButton = ResourcesCompat.getDrawable(resources,R.drawable.ic_clear_black_22dp,null)

        addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                showButton()
                show()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

    }

    fun show(){
        setOnTouchListener{view,motionEvent ->
            var isClicked:Boolean = false

            val clearButtonStart = (width - paddingEnd - darkButton!!.intrinsicWidth).toFloat()
            if(motionEvent.x > clearButtonStart){
                isClicked = true
            }

            if (isClicked){
                when(motionEvent.action){
                    MotionEvent.ACTION_DOWN -> text!!.clear()
                    MotionEvent.ACTION_UP -> hideButton()
                }
            }
            true
        }
    }

    fun showButton(){
        setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,darkButton,null)
    }

    fun hideButton(){
        setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,lightButton,null)
    }

    init{
        val tarry1 : TypedArray = context.obtainStyledAttributes(attrs,R.styleable.CustomEditText)
        try{
            setHint = tarry1.getString(R.styleable.CustomEditText_setHint)

            if(setHint == null)
                setHint("Enter your Message")
            else
                setHint("Enter Your Message here")

            setColor = tarry1.getBoolean(R.styleable.CustomEditText_setColor1,false)
            allCapital = tarry1.getBoolean(R.styleable.CustomEditText_allCapsEdit,false)

            if(setColor == true)
                setTextColor(Color.RED)

        }
        finally {
            tarry1.recycle()
            init()
        }


    }

}