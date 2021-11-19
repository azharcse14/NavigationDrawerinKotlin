package com.azhar.navigationdrawerinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azhar.navigationdrawerinkotlin.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
    lateinit var binding: ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val totalPrice: String = intent.getStringExtra("totalPrice").toString()
        binding.testTvId.text = totalPrice


    }
}