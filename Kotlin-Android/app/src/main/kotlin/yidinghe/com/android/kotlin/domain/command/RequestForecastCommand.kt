package yidinghe.com.android.kotlin.domain.command

import yidinghe.com.android.kotlin.data.server.ForecastRequest
import yidinghe.com.android.kotlin.domain.mapper.ForecastDataMapper
import yidinghe.com.android.kotlin.domain.model.ForecastList

/**
 * Created by yiding on 10/31/2016.
 */

class RequestForecastCommand(private val cityId: Long) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(cityId)
        return ForecastDataMapper().convertFromDataModel(cityId, forecastRequest.execute())
    }

}