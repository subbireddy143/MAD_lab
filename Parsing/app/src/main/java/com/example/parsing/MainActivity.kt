package com.example.parsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset
import javax.xml.parsers.DocumentBuilderFactory

class MainActivity : AppCompatActivity() {
    lateinit var xmlbtn: Button
    lateinit var jsonbtn: Button
    lateinit var city: TextView
    lateinit var lat: TextView
    lateinit var long: TextView
    lateinit var temp: TextView
    lateinit var humid: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        xmlbtn = findViewById(R.id.parsexmlbtn)
        jsonbtn = findViewById(R.id.parsejsonbtn)
        city = findViewById(R.id.cityname)
        lat = findViewById(R.id.latitude)
        long = findViewById(R.id.longitude)
        temp = findViewById(R.id.temperature)
        humid = findViewById(R.id.humidity)

        xmlbtn.setOnClickListener {
            parsexml()
        }

        jsonbtn.setOnClickListener {
            parsejson()
        }
    }

    private fun parsejson() {
        val obj = JSONObject(loadjson())
        city.text = "City name: " + obj.getString("City Name")
        lat.text = "Latitude: " + obj.getString("Latitude")
        long.text = "Longitude: " + obj.getString("Longitude")
        temp.text = "Temperature: " + obj.getString("Temperature")
        humid.text = "Humidity: " + obj.getString("Humidity")
    }

    private fun loadjson(): String {
        val json: String?
        try {
            val istream = assets.open("myjson.json")
            val size = istream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            istream.read(buffer)
            istream.close()
            json = String(buffer, charset)
        }
        catch (ex: IOException)
        {
            return " "
        }
        return json
    }

    private fun parsexml() {
        try {
            val istream = assets.open("myxml.xml")
            val db = DocumentBuilderFactory.newInstance()
            val docbuild = db.newDocumentBuilder()
            val doc = docbuild.parse(istream)
            city.text = "Cityname: " +doc.getElementsByTagName("Cityname").item(0).firstChild.nodeValue
            lat.text = "Latitude: " + doc.getElementsByTagName("Latitude").item(0).firstChild.nodeValue
            long.text = "Longitude: " + doc.getElementsByTagName("Longitude").item(0).firstChild.nodeValue
            temp.text = "Temperature: " + doc.getElementsByTagName("Temperature").item(0).firstChild.nodeValue
            humid.text = "Humidity: " + doc.getElementsByTagName("Humidity").item(0).firstChild.nodeValue
        }
        catch (ex: IOException)
        {

        }
    }
}