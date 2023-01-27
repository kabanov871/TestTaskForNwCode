package com.example.testtaskfornwcode.di

import androidx.lifecycle.ViewModel
import com.example.testtaskfornwcode.presentation.listImage.ListImageViewModel
import com.example.testtaskfornwcode.presentation.start.StartViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(StartViewModel::class)
    fun bindStartViewModel(viewModel: StartViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ListImageViewModel::class)
    fun bindListImageViewModel(viewModel: ListImageViewModel): ViewModel
}