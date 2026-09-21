package com.example.kotlin_hw2.HW02

import android.util.Log

// problem 1: median of three integers
fun problem1(a: Int, b: Int, c: Int) {
    val midVal = when {
        (b <= a && a <= c) || (c <= a && a <= b) -> a // mid val is a
        (a <= b && b <= c) || (c <= b && b <= a) -> b // mid val is b
        else -> c
    }
    Log.d("HW02", "Median of ($a, $b, $c) = $midVal")
}

// problem 2: random unique character array
fun problem2(capacity: Int) {
    val myUniqueSet = mutableSetOf<Char>() // make set for unique characters
    while (myUniqueSet.size < capacity) { // loop until full
        myUniqueSet.add(('a'..'z').random()) // add random lowercase char
    }
    val myUniqueArray = myUniqueSet.toCharArray() // convert to array
    Log.d("HW02", "result: ${myUniqueArray.toList()}, capacity: $capacity")
}

// problem 3: count upper, lower, and digits
fun problem3(line: String) {
    var upperCount = 0
    var lowerCount = 0
    var digitCount = 0

    for (char in line) { // iterate through each character
        if (char.isUpperCase()) upperCount++ // count uppercase letters
        else if (char.isLowerCase()) lowerCount++ // count lowercase letters
        else if (char.isDigit()) digitCount++ // count numbers
    }
    Log.d("HW02", "\"$line\" -> upper: $upperCount, lower: $lowerCount, digits: $digitCount")
}

// problem 4: trim first and last character iteratively
fun problem4(initialStr: String) {
    var str = initialStr
    var step = 0
    Log.d("HW02", "step $step: [$str]")

    while (str.length >= 2) { // run until fewer than 2 chars remain
        str = str.substring(1, str.length - 1) // trim first and last char
        step++
        Log.d("HW02", "step $step: [$str]") // print current string
    }
}

// problem 5: check for anagrams
fun problem5(str1: String, str2: String) {
    // remove spaces, convert to lowercase, and sort the characters
    val clean1 = str1.replace(" ", "").lowercase().toList().sorted()
    val clean2 = str2.replace(" ", "").lowercase().toList().sorted()

    if (clean1 == clean2) { // check if sorted lists match
        Log.d("HW02", "\"$str1\" and \"$str2\" are anagrams!")
        return
    }
    Log.d("HW02", "\"$str1\" and \"$str2\" are not anagrams!")
}

// problem 6: fibonacci sequence with a loop
fun problem6(n: Int) {
    var fibLoop = 0L // use long to prevent overflow

    if (n == 1) { // handle base case for 1
        fibLoop = 1L
    } else if (n > 1) { // compute for n greater than 1
        var prev = 0L
        var curr = 1L
        for (i in 2..n) { // loop from 2 to n
            fibLoop = prev + curr // calculate next number
            prev = curr // shift previous value
            curr = fibLoop // shift current value
        }
    }
    Log.d("HW02", "fibonacci($n) by loop = $fibLoop")
}
