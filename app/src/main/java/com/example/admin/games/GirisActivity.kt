package com.example.admin.games

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class GirisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giris)

        val backThread = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep((3000).toLong())
                    val i = Intent(this@GirisActivity, MainActivity::class.java)
                    startActivity(i)
                    finish()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        backThread.start()
    }
}
