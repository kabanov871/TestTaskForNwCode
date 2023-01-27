package com.example.testtaskfornwcode.domain

import javax.inject.Inject

data class UseCaseModel @Inject constructor(

    val imageId: Int,

    val largeImage: String,

    val previewImage: String
)
