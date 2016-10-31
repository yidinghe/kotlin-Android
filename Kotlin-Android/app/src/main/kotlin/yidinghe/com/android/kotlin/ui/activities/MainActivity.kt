package yidinghe.com.android.kotlin.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.async
import yidinghe.com.android.kotlin.R
import yidinghe.com.android.kotlin.data.Request
import yidinghe.com.android.kotlin.ui.adapters.ForecastListAdapter

class MainActivity : AppCompatActivity() {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast(R.string.app_name)

        val forecastRecyclerView: RecyclerView = find(R.id.forecast_RecyclerView)
        forecastRecyclerView.layoutManager = LinearLayoutManager(this)
        forecastRecyclerView.adapter = ForecastListAdapter(items)

        val url = "http://api.openweathermap.org/data/2.5/forecast/daily?" +
                "APPID=89d26475e5acaf51845ce3a0d4eb022b&q=94043&mode=json&units=metric&cnt=7"

        doAsync {
            Log.d(javaClass.simpleName, "start doAsync")
            Request(url).run()
            Log.d(javaClass.simpleName, "start doAsync, run")
            uiThread {
                Log.d(javaClass.simpleName, "start doAsync, Request performed")
                longToast("Request performed")
            }
        }

    }

}
