package com.example.admin.games

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_sayitahmin.*
import java.util.*

class SayitahminActivity : AppCompatActivity() {

    var sayi:Int=SayiUret()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sayitahmin)

        //Back button
        val actionBar=supportActionBar
        actionBar!!.title="Sayı Tahmin Oyunu"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val etTahmin=findViewById<EditText>(R.id.etTahmin) as EditText
        val btnTahmin=findViewById<Button>(R.id.btnTahmin) as Button
        val image=findViewById<ImageView>(R.id.ivSonuc) as ImageView
        val btnNew=findViewById<Button>(R.id.btnNew) as Button
        btnTahmin.setOnClickListener {
            var str:String=etTahmin.getText().toString()
            var tahmin: Int =Integer.parseInt(str)

           if (tahmin==sayi){
                tvSayiSonuc.setText(sayi.toString())
                tvTextSonuc.setText("Tebrikler, Sayı Bulundu..")
               image.setImageResource(R.drawable.success)
            }
           else if(tahmin<sayi){
               tvTextSonuc.setText("Düşük Tahminde Bulundunuz..")
              // tvSayiSonuc.setText(sayi.toString())
               image.setImageResource(R.drawable.down)
           }
           else if (tahmin>sayi){
               tvTextSonuc.setText("Yüksek Tahminde Bulundunuz..")
               //tvSayiSonuc.setText(sayi.toString())
               image.setImageResource(R.drawable.up)
           }
        }
        btnNew.setOnClickListener {
            sayi= SayiUret()
            tvSayiSonuc.setText("---")
        }
    }
    //back button için
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return  true
    }
    private fun SayiUret():Int {
        val random=Random().nextInt(100)+1
        return random
    }
}
