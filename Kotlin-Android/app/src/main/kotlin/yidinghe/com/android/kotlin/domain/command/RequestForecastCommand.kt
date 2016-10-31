package yidinghe.com.android.kotlin.domain.command

import yidinghe.com.android.kotlin.data.ForecastRequest
import yidinghe.com.android.kotlin.domain.mapper.ForecastDataMapper
import yidinghe.com.android.kotlin.domain.model.ForecastList

/**
 * Created by yiding on 10/31/2016.
 */

class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}