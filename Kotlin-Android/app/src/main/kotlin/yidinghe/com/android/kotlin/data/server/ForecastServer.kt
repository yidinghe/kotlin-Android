package yidinghe.com.android.kotlin.data.server

import yidinghe.com.android.kotlin.data.db.ForecastDb
import yidinghe.com.android.kotlin.domain.datasource.ForecastDataSource
import yidinghe.com.android.kotlin.domain.model.Forecast
import yidinghe.com.android.kotlin.domain.model.ForecastList

/**
 * Created by yiding.he on 1/13/2017.
 */

class ForecastServer(val dataMapper: ServerDataMapper = ServerDataMapper(), val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {

    override fun requestForecastByCityId(cityId: Long, date: Long): ForecastList? {
        val result = ForecastRequest(cityId).execute()
        val converted = result.let { dataMapper.convertResultToDomain(cityId, it) }
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByCityId(cityId, date)
    }

    override fun requestDayForecast(id: Long): Forecast? {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}