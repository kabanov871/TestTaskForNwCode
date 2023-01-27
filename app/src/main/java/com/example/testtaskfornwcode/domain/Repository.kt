package com.example.testtaskfornwcode.domain

import androidx.lifecycle.LiveData

interface Repository {

    val getAllImages: LiveData<List<UseCaseModel>>

    fun searchImages(category: String)
}