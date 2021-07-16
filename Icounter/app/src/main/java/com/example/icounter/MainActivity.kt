package com.example.icounter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var counter: TextView
    lateinit var startbutton: Button
    lateinit var stopbutton: Button
    var counterdemo: Int = 0

    val timer=Mycounter(100000,1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counter = findViewById(R.id.countervalue)
        startbutton = findViewById(R.id.start)
        stopbutton = findViewById(R.id.stop)

        startbutton.setOnClickListener {
            timer.start()
            startbutton.isEnabled = false
        }
        stopbutton.setOnClickListener {
            timer.cancel()
            startbutton.isEnabled = true
        }
    }

    inner class Mycounter(x:Long,y:Long): CountDownTimer(x,y){
        override fun onFinish()
        {
            counter.text="Range is over"
        }

        override fun onTick(millisUntilFinished: Long)
        {
            counterdemo++;
            counter.text=(counterdemo).toString();
        }

    }
}