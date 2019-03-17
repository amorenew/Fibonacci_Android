package com.amr.fibonacci

import android.app.Application
import android.content.Context
import com.amr.fibonacci.di.component.ApplicationComponent
import com.amr.fibonacci.di.component.DaggerApplicationComponent
import com.amr.fibonacci.di.module.ApplicationModule
import com.amr.fibonacci.helpers.FibonacciHelper
import com.amr.fibonacci.repository.ItemsRepository

import javax.inject.Inject

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var itemsRepository: ItemsRepository
    @Inject
    lateinit var fibonacciHelper: FibonacciHelper

    operator fun get(context: Context): Application {
        return context.applicationContext as Application
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)

    }

    fun getComponent(): ApplicationComponent {
        return applicationComponent
    }


}