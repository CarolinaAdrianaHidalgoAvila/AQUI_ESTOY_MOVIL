package com.aquiestoy.aqui_estoy

import com.aquiestoy.aqui_estoy.session.Prefs
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    companion object {
        var prefs: Prefs? = null
    }
    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
    }
}

val session: Prefs by lazy {
    App.prefs!!
}