package com.zm.pokemon.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.zm.pokemon.R

class ProgressDialog(context: Context) : Dialog(context) {
    init {
        val inflate = LayoutInflater.from(context).inflate(R.layout.progress_dialog, null)
        setContentView(inflate)
        setCancelable(false)
        window!!.setBackgroundDrawable(
            ColorDrawable(Color.TRANSPARENT)
        )
    }
}