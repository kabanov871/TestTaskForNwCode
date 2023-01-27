package com.example.testtaskfornwcode.presentation.start

import androidx.lifecycle.ViewModel
import com.example.testtaskfornwcode.domain.SearchImagesUseCase
import javax.inject.Inject

class StartViewModel @Inject constructor (
    private val searchImagesUseCase: SearchImagesUseCase): ViewModel() {

        fun searchImages(category: String) {
            searchImagesUseCase.searchImages(category)
        }
}