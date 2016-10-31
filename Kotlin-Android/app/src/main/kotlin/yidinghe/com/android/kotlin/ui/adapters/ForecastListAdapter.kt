package yidinghe.com.android.kotlin.ui.adapters

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.ViewGroup
import android.widget.TextView
import yidinghe.com.android.kotlin.domain.model.ForecastList

/**
 * Created by yiding on 10/31/2016.
 */

class ForecastListAdapter(val weekForecastList: ForecastList) : Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(weekForecastList.dailyForecast[position]) {
            holder?.textView?.text = "$date - $description - $high/$low"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent?.context))
    }

    override fun getItemCount(): Int = weekForecastList.dailyForecast.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}
