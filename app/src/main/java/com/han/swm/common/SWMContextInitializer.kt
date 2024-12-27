package com.han.swm.common

import android.app.Application
import android.content.Context
import androidx.startup.Initializer

class SWMContextInitializer: Initializer<Unit> {
    override fun create(context: Context) {
        SWMContextProvider.application = context.applicationContext as Application
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

}

object SWMContextProvider {
    lateinit var application: Application
    fun getApplicationContext(): Context {
        return application
    }
}