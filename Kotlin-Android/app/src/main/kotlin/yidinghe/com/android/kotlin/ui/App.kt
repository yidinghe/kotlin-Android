package yidinghe.com.android.kotlin.ui

import android.app.Application
import yidinghe.com.android.kotlin.ui.utils.DelegatesExt

/**
 * Created by yidinghe on 11/3/16.
 */

class App : Application() {

    companion object {
       lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}