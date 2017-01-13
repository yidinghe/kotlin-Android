package yidinghe.com.android.kotlin.data.db

/**
 * Created by yidinghe on 11/4/16.
 */

import org.jetbrains.anko.db.select
import org.jetbrains.anko.db.insert
import yidinghe.com.android.kotlin.data.server.City
import yidinghe.com.android.kotlin.domain.datasource.ForecastDataSource
import yidinghe.com.android.kotlin.domain.model.Forecast
import yidinghe.com.android.kotlin.domain.model.ForecastList
import yidinghe.com.android.kotlin.extensions.*
import java.util.*

class ForecastDb(val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance, val dbDataMapper: DbDataMapper = DbDataMapper()) : ForecastDataSource {

    override fun requestForecastByCityId(cityId: Long, date: Long) = forecastDbHelper.use {
        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME).whereSimple(dailyRequest, cityId.toString(), date.toString()).parseList { DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME).whereSimple("${CityForecastTable.ID} = ?", cityId.toString()).parseOpt { CityForecast(HashMap(it), dailyForecast) }

        city?.let { dbDataMapper.convertToDomain(it) }
    }

    override fun requestDayForecast(id: Long): Forecast? = forecastDbHelper.use {
        val forecast = select(DayForecastTable.NAME).byId(id).parseOpt { DayForecast(HashMap(it)) }
        forecast?.let { dbDataMapper.convertDayToDomain(it) }
    }

    fun saveForecast(forecastList: ForecastList) = forecastDbHelper.use {

        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)

        with(dbDataMapper.convertFromDomain(forecastList)) {
            insert(CityForecastTable.NAME, *map.toVarargArray())
            dailyForecast.forEach { insert(DayForecastTable.NAME, *it.map.toVarargArray()) }
        }
    }
}