package com.example.kotlin

/**
 * Created by loopeer on 2017/7/26.
 */
class kt {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sum2(a:Int,b:Int) = a+b;

    fun main(args: Array<String>) {
        print(sum(3,5))
        print(sum2(3,5))
    }
}