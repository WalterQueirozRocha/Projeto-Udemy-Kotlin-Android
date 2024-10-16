package com.example.projeto2udemy.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.projeto2udemy.MotivationConstants
import com.example.projeto2udemy.R
import com.example.projeto2udemy.SharedPreferences
import com.example.projeto2udemy.data.Mock
import com.example.projeto2udemy.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleFillter(R.id.image_all)
        handleNextPhrase()

        binding.btnNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageSun.setOnClickListener(this)
        binding.imageMoon.setOnClickListener(this)
        binding.userName.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_newPhrase) {
            handleNextPhrase()
        }
        else if(view.id in listOf(R.id.image_all, R.id.image_sun, R.id.image_moon)) {
            handleFillter(view.id)
        } else if(view.id == R.id.user_name){
            startActivity(Intent(this,UserActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        setUserName()
    }


    private fun setUserName(){
        val name = SharedPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.userName.text = "Olá, $name!"
    }
    private fun handleNextPhrase(){
        val phrase = Mock().getPhrase(categoryId, Locale.getDefault().language)
        binding.textCenter.text = phrase
    }

    private fun handleFillter(id: Int) {
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageMoon.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.image_sun -> {
                binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUN
            }
            R.id.image_moon -> {
                binding.imageMoon.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.MOON

            }
        }
    }
}