package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val result = callApi2()
        val a = 10
        println(result)
        println("$a")
        Thread.sleep(2000)
    }
}
fun callApi(){
    GlobalScope.launch {
        println("123")
    }
}
 fun callApi2() {
     GlobalScope.launch(Dispatchers.Unconfined) {
         val result = async {
             callApi3()
         }
         println("${result.await()}")
     }

}
suspend fun callApi3(): Any{
    var result = 1000
    return result
}
