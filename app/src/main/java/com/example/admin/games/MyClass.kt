package com.example.admin.games

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class MyClass
private constructor(context: Context){
    private val requestQueue:RequestQueue

    init {
        ctx=context
        requestQueue=getRequestQueue()
    }

    private fun getRequestQueue(): RequestQueue {
        return Volley.newRequestQueue(ctx)
    }
    companion object {
        private var ctx: Context?=null
        private val mInstance:MyClass?=null

        @Synchronized fun getInstance(context: Context):MyClass{
            return MyClass(context)
        }
    }
     fun <T> addToRequestQueue(request:Request<T>){
        requestQueue.add(request)
    }
}