package com.bypriyan.togocartpro.register

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
fun main() {

    CoroutineScope(Dispatchers.IO).launch {
        getApiRespUser()
        delay(1000)
        getApiResp()

    }

    CoroutineScope(Dispatchers.IO).launch {
        getApi()
    }


    normalFun()

    Thread.sleep(20000)

}

fun normalFun(){
    println("this is normal function: "+Thread.currentThread().name)
}


suspend fun getApi(){
    Thread.sleep(1000)
    println("got responce api, thread name is : "+Thread.currentThread().name)
}

suspend fun getApiResp(){
    Thread.sleep(500)
    println("got responce, thread name is : "+Thread.currentThread().name)
}

suspend fun getApiRespUser(){
    Thread.sleep(8000)
    println("got responce user, thread name is : "+Thread.currentThread().name)
}