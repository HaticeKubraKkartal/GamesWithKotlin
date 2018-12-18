package com.example.admin.games

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tactoe.*
import java.util.*
class TactoeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tactoe)
        //Back button
        val actionBar=supportActionBar
        actionBar!!.title="Tac Toe Oyunu"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }
    //back button için
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return  true
    }
    fun btnClick(view:View){
        var touchBtn=view as Button
        var btnID=0
        when(touchBtn.id){
            R.id.btn1->btnID=1
            R.id.btn2->btnID=2
            R.id.btn3->btnID=3
            R.id.btn4->btnID=4
            R.id.btn5->btnID=5
            R.id.btn6->btnID=6
            R.id.btn7->btnID=7
            R.id.btn8->btnID=8
            R.id.btn9->btnID=9
        }
        Oyna(btnID,touchBtn)
    }

    var oyuncu=ArrayList<Int>()
    var android=ArrayList<Int>()
    var aktif=1

    fun Oyna(btnID:Int,touchBtn:Button){
        if (aktif==1){
            touchBtn.setText("X")
            touchBtn.setBackgroundColor(getResources().getColor(R.color.color1))
            oyuncu.add(btnID)
            aktif=2
            AndroidOyna()
        }
        else{
            touchBtn.setText("O")
            touchBtn.setBackgroundColor(getResources().getColor(R.color.color2))
            android.add(btnID)
            aktif=1
        }
        touchBtn.isEnabled=false
        WinFind()

    }

    fun WinFind(){
        var win=1
        //1. row
        if (oyuncu.contains(1)&&oyuncu.contains(2)&&oyuncu.contains(3))
            win=1
        if (android.contains(1)&&android.contains(2)&&android.contains(3))
            win=2
        //2.row
        if (oyuncu.contains(4)&&oyuncu.contains(5)&&oyuncu.contains(6))
            win=1
        if (android.contains(4)&&android.contains(5)&&android.contains(6))
            win=2
        //3.row
        if (oyuncu.contains(7)&&oyuncu.contains(8)&&oyuncu.contains(9))
            win=1
        if (android.contains(7)&&android.contains(8)&&android.contains(9))
            win=2
        //1.column
        if (oyuncu.contains(1)&&oyuncu.contains(4)&&oyuncu.contains(7))
            win=1
        if (android.contains(1)&&android.contains(4)&&android.contains(7))
            win=2
        //2.column
        if (oyuncu.contains(2)&&oyuncu.contains(5)&&oyuncu.contains(8))
            win=1
        if (android.contains(2)&&android.contains(5)&&android.contains(8))
            win=2

        //3.column
        if (oyuncu.contains(3)&&oyuncu.contains(6)&&oyuncu.contains(9))
            win=1
        if (android.contains(3)&&android.contains(6)&&android.contains(9))
            win=2
        //Left Cross
        if (oyuncu.contains(1)&&oyuncu.contains(5)&&oyuncu.contains(9))
            win=1
        if (android.contains(1)&&android.contains(5)&&android.contains(9))
            win=2
        //Right Cross
        if (oyuncu.contains(3)&&oyuncu.contains(5)&&oyuncu.contains(7))
            win=1
        if (android.contains(3)&&android.contains(5)&&android.contains(7))
            win=2
        if(win!=-1){
            if(win==1)
                Toast.makeText(this,"Kazandınız",Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this,"Kaybettiniz",Toast.LENGTH_LONG).show()
        }
    }

    fun AndroidOyna(){
        var notTouchBnt=ArrayList<Int>()

        for (btnID in 1..9){
            if (!(oyuncu.contains(btnID))){
                notTouchBnt.add(btnID)
            }
        }
        var random=Random()
        val randomIndex=random.nextInt(notTouchBnt.size)
        val btnID=notTouchBnt[randomIndex]

        var choiceBtn:Button?=null

        when(btnID){
            1->choiceBtn=btn1
            2->choiceBtn=btn2
            3->choiceBtn=btn3
            4->choiceBtn=btn4
            5->choiceBtn=btn5
            6->choiceBtn=btn6
            7->choiceBtn=btn7
            8->choiceBtn=btn8
            9->choiceBtn=btn9
            else -> choiceBtn=btn1
        }
        Oyna(btnID ,choiceBtn)
    }
}
