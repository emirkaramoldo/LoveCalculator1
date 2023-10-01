package com.example.lovecalculator1.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lovecalculator.databinding.ActivityResultBinding
import com.example.lovecalculator1.App
import com.example.lovecalculator1.model.LoveModel

class ResultActivity: AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.historyBtn.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }
        binding.tryAgainBtn.setOnClickListener {
            finish()
        }

        val model = intent.getParcelableExtra<LoveModel>("model")!!
        App.appDatabase.loveDao().insert(model)
        binding.firstEd.text = model.firstName
        binding.secondEd.text = model.secondName
        binding.percentageTv.text = model.percentage
        binding.resultTv.text = model.result
    }

}