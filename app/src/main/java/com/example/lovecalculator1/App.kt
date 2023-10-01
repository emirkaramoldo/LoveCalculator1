package com.example.lovecalculator1

import  android.app.Application
import androidx.room.Room
import com.example.lovecalculator1.model.room.AppDatabase

class App: Application() {
    companion object{
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "love-base")
            .allowMainThreadQueries().build()
    }
}