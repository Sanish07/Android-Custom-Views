package com.example.cse225_part2

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import java.text.AttributedCharacterIterator

class CustomTextView : AppCompatTextView {
    private var title:String? = null
    private var color = false
    private var allCapital = false
    private var crop = 0

    constructor(context: Context) : super(context){}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        val tarray : TypedArray = context.obtainStyledAttributes(attrs,R.styleable.CustomTextView)

        try{
            title = tarray.getString(R.styleable.CustomTextView_settitle)

            if(title == null)
                setText("Custom Message")
            else
                setText("Hello")
            color = tarray.getBoolean(R.styleable.CustomTextView_setColor,false)
            allCapital = tarray.getBoolean(R.styleable.CustomTextView_allCapitals,false)
            crop = tarray.getInteger(R.styleable.CustomTextView_maxLength,title!!.length)

            if(color)
                setTextColor(Color.MAGENTA)

            if(crop != title!!.length)
              title = title?.substring(0,crop)

            if(allCapital)
                setText(title?.uppercase())
        }
        finally {
            tarray.recycle()
        }
    }

    constructor(context: Context,attrs: AttributeSet?,defStyleAttr:Int) : super(context,attrs,defStyleAttr)
}