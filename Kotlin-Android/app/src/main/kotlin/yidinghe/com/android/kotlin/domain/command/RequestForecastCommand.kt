package yidinghe.com.android.kotlin.domain.command

import yidinghe.com.android.kotlin.data.server.ForecastRequest
import yidinghe.com.android.kotlin.data.server.ServerDataMapper
import yidinghe.com.android.kotlin.domain.model.ForecastList

/**
 * Created by yiding on 10/31/2016.
 */

class RequestForecastCommand(private val cityId: Long) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(cityId)
        return ServerDataMapper().convertResultToDomain(cityId, forecastRequest.execute())
    }

}