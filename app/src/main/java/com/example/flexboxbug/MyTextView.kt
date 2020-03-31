package com.example.flexboxbug

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class MyTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    override fun layout(l: Int, t: Int, r: Int, b: Int) {
        super.layout(l, t, r, b)
        println("${this.shortName()} layout: l = [${l}], t = [${t}], r = [${r}], b = [${b}]")
    }

    fun Any.shortName(): String = "${this::class.java.simpleName}@${Integer.toHexString(this.hashCode())}"
}
