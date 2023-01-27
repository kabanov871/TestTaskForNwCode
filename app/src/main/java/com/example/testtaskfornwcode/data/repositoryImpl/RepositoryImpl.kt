package com.example.testtaskfornwcode.data.repositoryImpl

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.testtaskfornwcode.R
import com.example.testtaskfornwcode.data.dataBase.ImageDao
import com.example.testtaskfornwcode.data.mapper.Mapper
import com.example.testtaskfornwcode.data.models.DbModel
import com.example.testtaskfornwcode.data.models.Hit
import com.example.testtaskfornwcode.data.network.ApiInterface
import com.example.testtaskfornwcode.domain.Repository
import com.example.testtaskfornwcode.domain.UseCaseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor (
    private val imageDao: ImageDao,
    private val api: ApiInterface,
    private val application: Application,
    private val mapper: Mapper
        ): Repository {

    override val getAllImages: LiveData<List<UseCaseModel>>
        get() = Transformations.map(imageDao.getAllImages()) {
            mapper.mapListDbModelsToListUseCaseModels(it)
        }

    override fun searchImages(category: String) {

        CoroutineScope(Dispatchers.IO).launch {

            imageDao.clearImages()

            try {

                withContext(Dispatchers.Main) {
                    Toast.makeText(application, R.string.load, Toast.LENGTH_SHORT).show()
                }

                val imageList = ArrayList<Hit>()

                api.getImages(category).let {

                    if (it.isSuccessful) {

                        val response = it.body()

                        imageList.clear()

                        if (response != null) {

                            imageList.addAll(response.hits)
                        }

                        for (audit in imageList) {

                            DbModel(
                                0,
                                audit.id,
                                audit.largeImageURL,
                                audit.previewURL
                            ).let { imageDao.insertImage(it) }
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(application, R.string.load_fail, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(application, R.string.load_fail, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }


}