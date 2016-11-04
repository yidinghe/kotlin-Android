package yidinghe.com.android.kotlin.data.db

/**
 * Created by yidinghe on 11/4/16.
 */

import org.jetbrains.anko.db.select
import org.jetbrains.anko.db.insert
import yidinghe.com.android.kotlin.domain.model.ForecastList
import yidinghe.com.android.kotlin.extensions.clear
import yidinghe.com.android.kotlin.extensions.parseList
import yidinghe.com.android.kotlin.extensions.parseOpt
import yidinghe.com.android.kotlin.extensions.toVarargArray
import java.util.*

class ForecastDb(val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance, val dbDataMapper: DbDataMapper = DbDataMapper()) {

    fun requestForecastByCityId(cityId: Long, date: Long): ForecastList? = forecastDbHelper.use {

        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME).whereSimple(dailyRequest, cityId.toString(), date.toString()).parseList { DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME).whereSimple("${CityForecastTable.ID} = ?", cityId.toString()).parseOpt { CityForecast(HashMap(it), dailyForecast) }

        if (city != null) {
            dbDataMapper.convertToDomain(city)
        } else {
            null
        }
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