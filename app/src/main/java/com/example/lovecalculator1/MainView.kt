package com.example.lovecalculator1

import com.example.lovecalculator1.model.LoveModel

interface MainView {
    fun changeActivity(loveModel: LoveModel)
    fun showError(error: String)
}