package com.sedat.jetpacknavigationwithpaparauiclone.util

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

fun DialogFragment.setFullScreenSize(){
    val dialog = dialog
    if (dialog != null) {
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.MATCH_PARENT
        dialog.window!!.setLayout(width, height)
    }
}

fun DialogFragment.setDarkTransparentBackground(){
    dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.argb(100, 0, 0, 0)))
}