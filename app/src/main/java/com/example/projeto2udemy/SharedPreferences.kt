package com.example.projeto2udemy

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(context: Context) {

    private val security: SharedPreferences? =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)


    fun setString(key: String, str: String) {
        security?.edit()?.putString(key, str)?.apply()



    }

    fun getString(key: String): String {
        return security?.getString(key, "") ?:""
    }

}