package yidinghe.com.android.kotlin.domain.datasource

import yidinghe.com.android.kotlin.data.db.ForecastDb
import yidinghe.com.android.kotlin.data.server.ForecastServer

/**
 * Created by yiding.he on 1/13/2017.
 */

class ForecastProvider(val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLS = 1000 * 60 * 60 * 24
        val SOURCES = listOf(ForecastDb(), ForecastServer())
    }

}