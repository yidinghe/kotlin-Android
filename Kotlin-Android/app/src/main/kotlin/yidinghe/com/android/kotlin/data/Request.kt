package yidinghe.com.android.kotlin.data

import android.util.Log
import java.net.URL

/**
 * Created by yiding on 10/31/2016.
 */

class Request(val url: String) {

    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }

}
