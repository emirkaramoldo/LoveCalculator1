package com.example.lovecalculator1

import com.example.lovecalculator.model.RetrofitService
import com.example.lovecalculator1.model.LoveModel
import com.example.lovecalculator1.ui.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter {
    lateinit var view: MainView
    var service = RetrofitService()

    fun attachView(view: MainActivity){
        this.view = view
    }

    fun getLove(firstName: String, secondName: String){
        service.api.countCompability(firstName, secondName).enqueue(object : Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
               response.body()?.let {
                   view.changeActivity(it)
               }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
               view.showError(t.message.toString())
            }
        })
    }
}