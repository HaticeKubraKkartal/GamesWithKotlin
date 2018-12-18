package com.example.admin.games

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_topbul.*
import java.util.*

class TopbulActivity : AppCompatActivity() {

    var toplamPuan=50
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topbul)

        //Back button
        val actionBar=supportActionBar
        actionBar!!.title="Bul Topu Al Puanı"
        actionBar.setDisplayHomeAsUpEnabled(true)

        tvkredi.setText(toplamPuan.toString())
        btnYeni.setOnClickListener(){
            imageEnabled(true)
            tvSonuc.setText("")

            ibtn1.setBackgroundColor(Color.GRAY)
            ibtn2.setBackgroundColor(Color.GRAY)
            ibtn3.setBackgroundColor(Color.GRAY)

            ibtn1.setImageResource(android.R.color.transparent)
            ibtn2.setImageResource(android.R.color.transparent)
            ibtn3.setImageResource(android.R.color.transparent)
        }
    }

    //back button için
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
   fun btnSelect(view:View){

        val imgBtn=view as ImageButton
        var deger:Int
        val random=Random().nextInt(3)+1
        when(imgBtn.id){
            R.id.ibtn1->{
                deger=1
                OyunSonuc(random,deger)
                if(random==1) DogruTahmin()
                else YanlisTahmin()
            }
            R.id.ibtn2->{
                deger=2
                OyunSonuc(random,deger)
                if(random==2) DogruTahmin()
                else YanlisTahmin()
            }
            R.id.ibtn3->{
                deger=3
                OyunSonuc(random,deger)
                if(random==3) DogruTahmin()
                else YanlisTahmin()
            }
        }
    }

    private fun OyunSonuc(random:Int,deger:Int) {
        ibtn1.setBackgroundColor(Color.TRANSPARENT)
        ibtn2.setBackgroundColor(Color.TRANSPARENT)
        ibtn3.setBackgroundColor(Color.TRANSPARENT)

        imageEnabled(false)

        if (random==1){
            ibtn1.setImageResource(R.drawable.beach)
            if (deger==2)
                ibtn2.setImageResource(R.drawable.error)
            else if(deger==3)
                ibtn3.setImageResource(R.drawable.error)
        }
        else if (random==2){
            ibtn2.setImageResource(R.drawable.beach)
            if (deger==1)
                ibtn1.setImageResource(R.drawable.error)
            else if(deger==3)
                ibtn3.setImageResource(R.drawable.error)
        }
        else if(random==3){
            ibtn3.setImageResource(R.drawable.beach)
            if (deger==1)
                ibtn1.setImageResource(R.drawable.error)
            else if(deger==2)
                ibtn2.setImageResource(R.drawable.error)
        }
    }

    private fun imageEnabled(bool: Boolean) {
        ibtn1.isEnabled=bool
        ibtn2.isEnabled=bool
        ibtn3.isEnabled=bool
    }
    private fun YanlisTahmin() {
        tvSonuc.setText("Maalesef Kaybettiniz")
        toplamPuan-=10
        tvkredi.setText(toplamPuan.toString())
    }
    private fun DogruTahmin() {
        tvSonuc.setText("Tebrikler, Kazandınız")
        toplamPuan+=10
        tvkredi.setText(toplamPuan.toString())
    }
}
