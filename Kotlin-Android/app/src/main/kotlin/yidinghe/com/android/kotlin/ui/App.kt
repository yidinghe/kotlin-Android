package yidinghe.com.android.kotlin.ui

import android.app.Application

/**
 * Created by yidinghe on 11/3/16.
 */

class App : Application() {

    companion object {
        private var instance: Application? = null
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}