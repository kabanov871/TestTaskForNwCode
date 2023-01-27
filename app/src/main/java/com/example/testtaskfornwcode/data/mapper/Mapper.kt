package com.example.testtaskfornwcode.data.mapper

import com.example.testtaskfornwcode.data.models.DbModel
import com.example.testtaskfornwcode.domain.UseCaseModel
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun mapDbModelToUseCaseModel(model: DbModel) = UseCaseModel(
        imageId = model.imageId,
        largeImage = model.largeImage,
        previewImage = model.previewImage
    )

    fun mapListDbModelsToListUseCaseModels(list: List<DbModel>) = list.map {
        mapDbModelToUseCaseModel(it)
    }
}