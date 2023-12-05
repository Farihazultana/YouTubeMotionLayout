package com.example.motionlayout.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by Estiak on 12/5/23
 */
object Config {
    fun showShortToast(context: Context?, message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}