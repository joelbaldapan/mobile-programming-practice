package com.example.kotlin_hw2

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.kotlin_hw2.HW02.*
import com.example.kotlin_hw2.HW03.*
import com.example.kotlin_hw2.HW04.*


fun hw2hw3Tests() {
    // Problem 1: Median of three integers
    problem1(12, 27, 27)
    problem1(12, 19, 27)
    problem1(45, 21, 35)
    problem1(31, 21, 100)
    problem1(7, 7, 7)

    // Problem 2: Unique random character array
    problem2(10)
    problem2(10)
    problem2(5)
    problem2(5)
    problem2(26)

    // Problem 3: Count upper, lower, and digits
    problem3("Kotlin 2.1 runs on Android 15!")
    problem3("Hello World!")
    problem3("SeoulTech IXLAB, room 319-2")

    // Problem 4: Repeatedly remove first and last characters
    problem4("Programming")
    problem4("Android")
    problem4("Kotlin")

    // Problem 5: Check for anagrams
    problem5("Listen", "Silent")
    problem5("Dormitory", "Dirty Room")
    problem5("Kotlin", "Java")

    // Problem 6: N-th Fibonacci number
    problem6(0)
    problem6(1)
    problem6(10)
    problem6(30)
    problem6(40)

    testEasy()
    testMedium()
    testDifficult()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // NAME: Joel Angelo Baldapan        hw4Problem5()
        // STUDENT NUMBER: 26170176

        // HW04 TEST CASES
        hw4Problem1()
        hw4Problem2()
        hw4Problem3()
        hw4Problem4()
        hw4Problem5()
        hw4Problem6()
    }
}