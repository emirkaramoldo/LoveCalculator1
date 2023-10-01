package com.example.lovecalculator1.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lovecalculator.databinding.ActivityHistoryBinding
import com.example.lovecalculator1.App
import com.example.lovecalculator1.model.LoveModel

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding

    private val adapter = HistoryAdapter(this::onLongClick, this::onClick)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter
        val data = App.appDatabase.loveDao().getAll()
        adapter.addItems(data)
        binding.backBtn.setOnClickListener {
            finish()
        }
    }
    private fun onClick(item: LoveModel){

        val alert = AlertDialog.Builder(this)
            .setTitle("Информация")
            .setMessage("Дата создания:")
        alert.create().show()
    }

    private fun onLongClick(item: LoveModel) {
        val alert = AlertDialog.Builder(this)
            .setTitle("Вы хотите удалить?")
            .setPositiveButton("Да"){_, _ ->
                App.appDatabase.loveDao().delete(item)
                setData()
            }
            .setNegativeButton("Нет"){dialog, _ -> dialog.dismiss()
            }
        alert.create().show()
    }

    private fun setData(){
        val data = App.appDatabase.loveDao().getAll()
        adapter.addItems(data)
    }
}
