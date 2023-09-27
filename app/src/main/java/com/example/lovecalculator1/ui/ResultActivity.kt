package com.example.lovecalculator1.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lovecalculator.databinding.ActivityResultBinding
import com.example.lovecalculator1.model.LoveModel

class ResultActivity: AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model = intent.getSerializableExtra("model") as LoveModel
        binding.firstEd.text = model.firstName.toString()
        binding.secondEd.text = model.secondName.toString()
        binding.percentageTv.text = model.percentage.toString()
        binding.resultTv.text = model.result.toString()
    }

}