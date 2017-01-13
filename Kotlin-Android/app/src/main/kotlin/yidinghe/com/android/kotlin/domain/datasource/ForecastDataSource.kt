package yidinghe.com.android.kotlin.domain.datasource

import yidinghe.com.android.kotlin.domain.model.Forecast
import yidinghe.com.android.kotlin.domain.model.ForecastList

/**
 * Created by yiding.he on 1/13/2017.
 */
interface ForecastDataSource {

    fun requestForecastByCityId(cityId: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?


}