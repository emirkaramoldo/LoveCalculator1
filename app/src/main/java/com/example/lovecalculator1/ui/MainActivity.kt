package com.example.lovecalculator1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.lovecalculator.databinding.ActivityMainBinding
import com.example.lovecalculator1.MainPresenter
import com.example.lovecalculator1.MainView
import com.example.lovecalculator1.model.LoveModel

class MainActivity : AppCompatActivity(), MainView {
    lateinit var binding: ActivityMainBinding
    val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClickers()
    }

    private fun initClickers() {
        with(binding){
            calculatorBtn.setOnClickListener{
                presenter.getLove(firstEd.text.toString(), secondEd.text.toString())
            }
        }
    }

    override fun changeActivity(loveModel: LoveModel) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("model", loveModel)
        startActivity(intent)
    }

    override fun showError(error: String) {
        Toast.makeText(this,error, Toast.LENGTH_SHORT).show()
    }
}