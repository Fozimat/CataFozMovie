package com.fozimat.catafozmovie.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fozimat.catafozmovie.ui.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splash = Intent(this, MainActivity::class.java)
        startActivity(splash)
        finish()
    }
}