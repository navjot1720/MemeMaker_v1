package com.example.mememaker_v1.util

import android.graphics.Color


val colorList = mutableListOf<Int>(Color.parseColor("#FFA07A")
    , Color.parseColor("#EEE8AA")
    , Color.parseColor("#9ACD32")
    , Color.parseColor("#90EE90")
    , Color.parseColor("#E0FFFF")
    , Color.parseColor("#87CEEB")
    , Color.parseColor("#FAEBD7")
    , Color.parseColor("#B0C4DE")
    , Color.parseColor("#B0C4DE")
    , Color.parseColor("#DCDCDC")
)

fun getRandomColor(): Int {
    return colorList.random()
}