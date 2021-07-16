package com.example.iwallpaper

import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var Change_Walpaper:Button

    var wallpaperlist = arrayOf(R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Change_Walpaper = findViewById(R.id.ChangeWallpaper)
        Change_Walpaper.setOnClickListener{WallpaperChange()}
    }
    @SuppressLint("MissingPermission")
    private fun WallpaperChange(){
        Handler().postDelayed({
            for (i in wallpaperlist) {
                var wallpaper_manager = WallpaperManager.getInstance(baseContext)
                var bitmap = BitmapFactory.decodeResource(resources,i)
                wallpaper_manager.setBitmap(bitmap)
            }
        },1000)
    }
}