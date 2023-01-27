package com.example.testtaskfornwcode.domain

import javax.inject.Inject

class GetImagesUseCase @Inject constructor (private val repository: Repository) {

    val getImages = repository.getAllImages
}