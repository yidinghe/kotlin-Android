package yidinghe.com.android.kotlin.data.server

import yidinghe.com.android.kotlin.data.server.Forecast
import yidinghe.com.android.kotlin.data.server.ForecastResult

import yidinghe.com.android.kotlin.domain.model.ForecastList
import yidinghe.com.android.kotlin.domain.model.Forecast as ModelForecast
import java.text.DateFormat
import java.util.*

/**
 * Created by yiding on 10/31/2016.
 */

class ServerDataMapper {


    fun convertResultToDomain(id: Long, forecastResult: ForecastResult): ForecastList = with(forecastResult) {
         ForecastList(id, city.name, city.country, convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<yidinghe.com.android.kotlin.domain.model.Forecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): yidinghe.com.android.kotlin.domain.model.Forecast = with(forecast) {
        yidinghe.com.android.kotlin.domain.model.Forecast(dt * 1000, weather[0].description, temp.max.toInt(), temp.min.toInt(), generateIconUrl(weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"


}