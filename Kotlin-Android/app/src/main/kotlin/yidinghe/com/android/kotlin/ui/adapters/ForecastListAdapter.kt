package yidinghe.com.android.kotlin.ui.adapters

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import yidinghe.com.android.kotlin.R
import yidinghe.com.android.kotlin.domain.model.Forecast
import yidinghe.com.android.kotlin.domain.model.ForecastList
import yidinghe.com.android.kotlin.ui.utils.ctx

/**
 * Created by yiding on 10/31/2016.
 */

class ForecastListAdapter(val weekForecastList: ForecastList, val itemClick: (Forecast) -> Unit ) : Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindForecast(weekForecastList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = weekForecastList.size()

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit ) : RecyclerView.ViewHolder(view) {
        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }

        fun bindForecast(forecast: Forecast) {

            with(forecast) {
                //View.ctx: Defined at ViewExtensions.kt
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "$high"
                minTemperatureView.text = "$low"
                itemView.setOnClickListener { itemClick(this) }
            }
        }

    }

}
