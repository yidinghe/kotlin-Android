package yidinghe.com.android.kotlin.data

import com.google.gson.Gson
import java.net.URL

/**
 * Created by yiding on 10/31/2016.
 */

class ForecastRequest(val zipCode: String) {

    companion object {
        private val APP_ID = "89d26475e5acaf51845ce3a0d4eb022b";
        private val LOCAL_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$LOCAL_URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }

}