package com.amr.fibonacci.di.module

import android.app.Application
import android.content.Context
import com.amr.fibonacci.di.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val mApplication: Application) {

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context {
        return mApplication
    }

    @Provides
    internal fun provideApplication(): Application {
        return mApplication
    }

    //    @Provides
    //    @DatabaseInfo
    //    String provideDatabaseName() {
    //        return "demo-dagger.db";
    //    }

    //    @Provides
    //    @DatabaseInfo
    //    Integer provideDatabaseVersion() {
    //        return 2;
    //    }

    //    @Provides
    //    SharedPreferences provideSharedPrefs() {
    //        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    //    }
}