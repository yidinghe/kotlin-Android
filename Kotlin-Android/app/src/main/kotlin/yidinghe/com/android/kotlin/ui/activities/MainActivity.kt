package yidinghe.com.android.kotlin.ui.activities

import android.os.Build
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
import yidinghe.com.android.kotlin.util.supportLoliop
import kotlinx.android.synthetic.main.activity_main.forecast_RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast(R.string.app_name)

//        val forecastRecyclerView: RecyclerView = find(R.id.forecast_RecyclerView)
        forecast_RecyclerView.layoutManager = LinearLayoutManager(this)

        doAsync {
            Log.d(javaClass.simpleName, "start doAsync")
            val result: ForecastList = RequestForecastCommand("4944994").execute()
            Log.d(javaClass.simpleName, "start doAsync, run")
            Log.d(javaClass.simpleName, "result:" + result)

            uiThread {
                Log.d(javaClass.simpleName, "start doAsync, Request performed")
                longToast("Request performed")
                forecast_RecyclerView.adapter = ForecastListAdapter(result) {toast(it.date)}
                // OR
                //forecastRecyclerView.adapter = ForecastListAdapter(result, {forecast -> toast(forecast.date)})

                supportLoliop {
                    Log.d(javaClass.simpleName, "supportLoliop:" + Build.VERSION.SDK_INT)
                }

            }
        }

    }

}
