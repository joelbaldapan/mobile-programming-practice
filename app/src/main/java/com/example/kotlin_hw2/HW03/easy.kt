package com.example.kotlin_hw2.HW03

import android.util.Log


fun generousGacha(packs: List<List<String>>): Set<String> {
    return packs
        .filter { pack ->
            // a generous pack has at least two 3-star cards
            pack.count { card -> card.startsWith("*** ") } >= 2
        }
        .flatten() // combine all cards from the generous packs into one list
        .filter { card -> card.startsWith("*** ") } // keep only the 3-star cards
        .map { rareCard -> rareCard.substring(4) } // remove the "*** " prefix
        .toSet() // convert to a Set so that idols become unique
}

fun testEasy() {
    val testCase1 = listOf(
        listOf("*** Jimin", "* Jin", "*** Suga", "** J-Hope")
    )
    Log.d("HW03", "Easy Test 1: ${generousGacha(testCase1)}")

    val testCase2 = listOf(
        listOf("*** Lisa", "* Jisoo", "** Jennie", "* Rose"),
        listOf("*** Lisa", "*** Rose", "** Jisoo", "* Jennie")
    )
    Log.d("HW03", "Easy Test 2: ${generousGacha(testCase2)}")

    val testCase3 = listOf(
        listOf("* Karina", "** Winter", "* Ningning", "** Giselle")
    )
    Log.d("HW03", "Easy Test 3: ${generousGacha(testCase3)}")
}
