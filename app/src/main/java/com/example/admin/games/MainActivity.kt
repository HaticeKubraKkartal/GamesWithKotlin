package com.example.admin.games

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val fileName="video"
        val filepath="android.resource://"+packageName+"/raw/"+R.raw.ball_gif
        val videoView=findViewById<VideoView>(R.id.videoGif) as VideoView
        videoView.setVideoURI(Uri.parse(filepath))
        videoView.setMediaController(MediaController(this))
        videoView.start()

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_main -> {
                // Handle the camera action
                val intent=Intent(baseContext,MainActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_tactoe -> {
                val intent=Intent(baseContext,TactoeActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_topbul -> {
                val intent=Intent(baseContext,TopbulActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_sayitahmin -> {
                val intent=Intent(baseContext,SayitahminActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_kural -> {
                val intent=Intent(baseContext,OyunkuralActivity::class.java)
                startActivity(intent)
            }

            R.id.nav_exit->{
                val builder=AlertDialog.Builder(this)
                builder.setMessage("Çıkış Yapılsın Mı?")
                builder.setCancelable(true)
                builder.setNegativeButton("Hayır",DialogInterface.OnClickListener { dialogInterface, i ->
                    dialogInterface.cancel()
                })
                builder.setPositiveButton("Evet",DialogInterface.OnClickListener { dialogInterface, i ->
                    finish()
                })
                val alertDialog=builder.create()
                alertDialog.show()
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
