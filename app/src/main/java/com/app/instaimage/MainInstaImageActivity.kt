package com.app.instaimage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.instaimage.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainInstaImageActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        //useful in below Android 11, removes the logo which act as splash screen.
        window?.setBackgroundDrawableResource(R.color.white)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}