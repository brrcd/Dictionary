package com.example.dictionary

import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible

fun View.setGone(){
    isGone = true
}

fun View.setVisible(){
    isVisible = true
}