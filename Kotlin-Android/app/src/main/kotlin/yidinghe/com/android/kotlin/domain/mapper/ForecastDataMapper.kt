package yidinghe.com.android.kotlin.domain.mapper

import yidinghe.com.android.kotlin.data.Forecast
import yidinghe.com.android.kotlin.data.ForecastResult

import yidinghe.com.android.kotlin.domain.model.ForecastList
import yidinghe.com.android.kotlin.domain.model.Forecast as ModelForecast
import java.text.DateFormat
import java.util.*

/**
 * Created by yiding on 10/31/2016.
 */

class ForecastDataMapper {


    fun convertFromDataModel(forecastResult: ForecastResult): ForecastList {
        return ForecastList(forecastResult.city.name, forecastResult.city.country, convertForecastListToDomain(forecastResult.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description, forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }


    private fun convertDate(date: Long): String {
        val dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return dateFormat.format(date * 1000)
    }

}