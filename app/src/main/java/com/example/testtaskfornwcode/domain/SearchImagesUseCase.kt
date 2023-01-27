package com.example.testtaskfornwcode.domain

import javax.inject.Inject

class SearchImagesUseCase @Inject constructor (private val repository: Repository) {

    fun searchImages(category: String) {

        repository.searchImages(category)
    }
}