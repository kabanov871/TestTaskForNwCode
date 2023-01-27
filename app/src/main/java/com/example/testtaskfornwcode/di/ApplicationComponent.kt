package com.example.testtaskfornwcode.di

import android.app.Application
import com.example.testtaskfornwcode.presentation.fullScreen.FullScreenFragment
import com.example.testtaskfornwcode.presentation.listImage.ListImagesFragment
import com.example.testtaskfornwcode.presentation.start.StartFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: StartFragment)

    fun inject(fragment: ListImagesFragment)

    fun inject(fragment: FullScreenFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}