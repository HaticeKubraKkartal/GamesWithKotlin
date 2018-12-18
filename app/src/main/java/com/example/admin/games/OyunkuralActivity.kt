package com.example.admin.games

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.ImageRequest

class OyunkuralActivity : AppCompatActivity(){

    var image_URL:String="https://cdn0.iconfinder.com/data/icons/game-design/64/i562-512.png"
    var imgView:ImageView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oyunkural)
        imgView=findViewById<ImageView>(R.id.ivKural)as ImageView

        val imageReq=ImageRequest(image_URL,Response.Listener<Bitmap> { response ->
            imgView!!.setImageBitmap(response)},200,200,ImageView.ScaleType.FIT_CENTER,
                null,Response.ErrorListener { error ->
            Toast.makeText(this,"Hata!! "+error.message,Toast.LENGTH_SHORT).show()
            error.printStackTrace()
        })
        MyClass.getInstance(this.applicationContext).addToRequestQueue(imageReq)

        //Back button
        val actionBar=supportActionBar
        actionBar!!.title="Oyun Kuralları"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    //back button için
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return  true
    }
}
