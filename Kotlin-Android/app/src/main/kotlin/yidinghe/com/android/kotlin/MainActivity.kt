package yidinghe.com.android.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.message_text
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message_text.text = "Hello Kotlin!"
        Log.d("KOTLIN", "MainActivity, onCreate")
        toast("hahahha")
    }

}
