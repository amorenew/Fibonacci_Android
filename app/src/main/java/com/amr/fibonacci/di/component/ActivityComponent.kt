package com.amr.fibonacci.di.component

import com.amr.fibonacci.MainActivity
import com.amr.fibonacci.di.PerActivity
import com.amr.fibonacci.di.module.ActivityModule
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}
