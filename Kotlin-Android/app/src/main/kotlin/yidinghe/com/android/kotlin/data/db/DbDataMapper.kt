package yidinghe.com.android.kotlin.data.db

import yidinghe.com.android.kotlin.domain.model.Forecast
import yidinghe.com.android.kotlin.domain.model.ForecastList

/**
 * Created by yidinghe on 11/4/16.
 */

class DbDataMapper {

    fun convertFromDomain(forecastList: ForecastList): CityForecast = with(forecastList) {
        val daily = dailyForecast.map { convertDayFromDomain(id, it) }
        CityForecast(id, city, country, daily)
    }

    fun convertDayFromDomain(cityId: Long, forecast: Forecast): DayForecast = with(forecast) {
        DayForecast(date, description, high, low, iconUrl, cityId)
    }

    fun convertToDomain(cityForecast: CityForecast): ForecastList = with(cityForecast) {
        val daily = dailyForecast.map { convertDayToDomain(it) }
        ForecastList(_id, city, country, daily)
    }

    fun convertDayToDomain(dayForecast: DayForecast): Forecast = with(dayForecast) {
        Forecast(date, description, high, low, iconUrl)
    }

}