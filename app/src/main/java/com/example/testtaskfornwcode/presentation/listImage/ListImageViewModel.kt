package com.example.testtaskfornwcode.presentation.listImage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.testtaskfornwcode.domain.GetImagesUseCase
import com.example.testtaskfornwcode.domain.UseCaseModel
import javax.inject.Inject

class ListImageViewModel @Inject constructor (
    private val getImagesUseCase: GetImagesUseCase): ViewModel() {

        val getImages: LiveData<List<UseCaseModel>> = getImagesUseCase.getImages
}