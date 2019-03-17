package com.amr.fibonacci.di.component

import android.app.Application
import android.content.Context
import com.amr.fibonacci.MyApplication
import com.amr.fibonacci.di.ApplicationContext
import com.amr.fibonacci.di.module.ApplicationModule
import com.amr.fibonacci.helpers.FibonacciHelper
import com.amr.fibonacci.repository.ItemsRepository
import dagger.Component

import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    @get:ApplicationContext
    val context: Context

    val application: Application

    val itemsRepository: ItemsRepository

    val fibonacciHelper: FibonacciHelper

    fun inject(demoApplication: MyApplication)

}
