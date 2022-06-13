package com.zm.pokemon.view


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zm.pokemon.utils.ProgressDialog

abstract class BaseActivity : AppCompatActivity() {
    private var dialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialog = ProgressDialog(this)
    }

    fun showProgress() {
        dialog?.show()
    }

    fun cancelProgress() {
        if (dialog!!.isShowing) dialog?.cancel()
    }


}