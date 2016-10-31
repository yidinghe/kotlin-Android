package yidinghe.com.android.kotlin.domain.model

/**
 * Created by yiding on 10/31/2016.
 */

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>)

data class Forecast(val date: String, val description: String, val high: Int, val low: Int)