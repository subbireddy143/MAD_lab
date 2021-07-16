package com.example.phonedial

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var one: TextView
    private lateinit var two: TextView
    private lateinit var three: TextView
    private lateinit var four: TextView
    private lateinit var five: TextView
    private lateinit var six: TextView
    private lateinit var seven: TextView
    private lateinit var eight: TextView
    private lateinit var nine: TextView
    private lateinit var zero: TextView
    private lateinit var star: TextView
    private lateinit var hash: TextView
    private lateinit var clear: Button
    private lateinit var save: Button
    private lateinit var call: Button
    private lateinit var number: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zero = findViewById(R.id.zero)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        star = findViewById(R.id.star)
        hash = findViewById(R.id.hash)
        save = findViewById(R.id.save)
        call = findViewById(R.id.call)
        clear = findViewById(R.id.clear)
        number = findViewById(R.id.number)

        zero.setOnClickListener {
            pressbutton("0", true)
        }
        one.setOnClickListener {
            pressbutton("1", true)
        }
        two.setOnClickListener {
            pressbutton("2", true)
        }
        three.setOnClickListener {
            pressbutton("3", true)
        }
        four.setOnClickListener {
            pressbutton("4", true)
        }
        five.setOnClickListener {
            pressbutton("5", true)
        }
        six.setOnClickListener {
            pressbutton("6", true)
        }
        seven.setOnClickListener {
            pressbutton("7", true)
        }
        eight.setOnClickListener {
            pressbutton("8", true)
        }
        nine.setOnClickListener {
            pressbutton("9", true)
        }
        hash.setOnClickListener {
            pressbutton("#", true)
        }
        star.setOnClickListener {
            pressbutton("*", true)
        }
        clear.setOnClickListener {
            number.text = ""
        }
        call.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "${number.text}"))
            startActivity(intent)
        }
        save.setOnClickListener {
            val intent = Intent(
                    ContactsContract.Intents.SHOW_OR_CREATE_CONTACT,Uri.parse("tel:" + number.text))
            intent.putExtra(ContactsContract.Intents.EXTRA_FORCE_CREATE, true)
            startActivity(intent)

        }


    }

    fun pressbutton(string: String, clear: Boolean) {
        number.append(string)

    }
}