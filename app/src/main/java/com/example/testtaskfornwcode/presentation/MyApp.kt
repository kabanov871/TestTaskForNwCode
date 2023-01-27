package com.example.testtaskfornwcode.presentation

import android.app.Application
import com.example.testtaskfornwcode.di.DaggerApplicationComponent

class MyApp: Application() {

    val component by lazy {

        DaggerApplicationComponent.factory().create(this)
    }
}