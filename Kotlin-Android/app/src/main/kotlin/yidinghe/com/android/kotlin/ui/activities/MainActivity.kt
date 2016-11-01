package yidinghe.com.android.kotlin.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import org.jetbrains.anko.*
import yidinghe.com.android.kotlin.R
import yidinghe.com.android.kotlin.domain.command.RequestForecastCommand
import yidinghe.com.android.kotlin.domain.model.Forecast
import yidinghe.com.android.kotlin.domain.model.ForecastList
import yidinghe.com.android.kotlin.ui.adapters.ForecastListAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast(R.string.app_name)

        val forecastRecyclerView: RecyclerView = find(R.id.forecast_RecyclerView)
        forecastRecyclerView.layoutManager = LinearLayoutManager(this)

        doAsync {
            Log.d(javaClass.simpleName, "start doAsync")
            val result: ForecastList = RequestForecastCommand("4944994").execute()
            Log.d(javaClass.simpleName, "start doAsync, run")
            Log.d(javaClass.simpleName, "result:" + result)

            uiThread {
                Log.d(javaClass.simpleName, "start doAsync, Request performed")
                longToast("Request performed")
                forecastRecyclerView.adapter = ForecastListAdapter(result, object : ForecastListAdapter.OnItemClickListener {
                    override fun invoke(forecast: Forecast) {
                        toast(forecast.date)
                    }

                })
            }
        }

    }

}
