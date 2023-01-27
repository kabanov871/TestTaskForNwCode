package com.example.testtaskfornwcode.di

import android.app.Application
import com.example.testtaskfornwcode.data.dataBase.ImageDao
import com.example.testtaskfornwcode.data.dataBase.ImageDatabase
import com.example.testtaskfornwcode.data.network.ApiInterface
import com.example.testtaskfornwcode.data.repositoryImpl.RepositoryImpl
import com.example.testtaskfornwcode.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindRepository(impl: RepositoryImpl): Repository

    companion object {

        @Provides
        @ApplicationScope
        fun provideImageDao(application: Application): ImageDao {
            return ImageDatabase.getInstance(application).imageDao
        }

        @Provides
        fun baseUrl() = "https://pixabay.com/"

        @Provides
        @ApplicationScope
        fun provideRetrofit(baseUrl: String): ApiInterface =
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
    }
}