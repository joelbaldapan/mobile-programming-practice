package com.example.kotlin_hw2.HW03

import android.util.Log

fun minPuddles(layout: List<String>): Int? {
    val r = layout.size      // number of rows
    val c = layout[0].length // number of cols

    // we will cache the result for every cell and seenPuddles at that cell
    // by memoizing, we make sure that the time complexity is Theta(n^2).
    // in the form: { (i, j, seenPuddles): function return value }
    val memo = mutableMapOf<Triple<Int, Int, Int>, Int>()

    fun minPuddlesToCell(i: Int, j: Int, seenPuddles: Int): Int {
        // returns the "minimum puddles needed to go from (i, j) to (r-1, c-1)"

        // BASE CASES
        var newSeenPuddles = seenPuddles
        if (
            !(0 <= i && i < r && 0 <= j && j < c) || // out of bounds
            layout[i][j] == 'o' // on boulder
        ) {
            return Int.MAX_VALUE // invalid!
        } else if (layout[i][j] == '^') {
            newSeenPuddles++ // fell into muddly puddle
        } else if (i == r-1 && j == c-1) {
            return newSeenPuddles // reached the goal
        }

        // check cache
        val state = Triple(i, j, newSeenPuddles)
        if (state in memo) return memo[state]!! // we are certain it is not null

        // RECURSIVE CASE
        val result = minOf(
            minPuddlesToCell(i+1, j, newSeenPuddles), // walk 1, down
            minPuddlesToCell(i+2, j, newSeenPuddles), // jump 2, down
            minPuddlesToCell(i, j+1, newSeenPuddles), // walk 1, right
            minPuddlesToCell(i, j+2, newSeenPuddles), // jump 2, right
        )

        // save to cache
        memo[state] = result
        return result
    }

    // by function definition, this returns the "min. puddles needed to go from (0, 0) to (r-1, c-1)"
    val result = minPuddlesToCell(0, 0, 0)
    if (result == Int.MAX_VALUE) return null // return null if impossible
    return result // if valid, then we simply return the result
}

fun testDifficult() {
    val testCase1 = listOf(
        ".^^.",
        "^oo.",
        "^oo.",
        "^^..",
    )
    Log.d("HW03", "Difficult Test 1: ${minPuddles(testCase1)}")
    val testCase2 = listOf(
        ".oo",
        "ooo",
        "oo."
    )
    Log.d("HW03", "Difficult Test 2: ${minPuddles(testCase2)}")
    val testCase3 = listOf(
        ".^.^.^.^.^",
        "oooooooooo",
        ".^.^.^.^.^",
        "oooooooooo",
        ".^.^.^.^.^",
        "oooooooooo",
        ".^.^.^.^.^",
        "oooooooooo",
        ".^.^.^.^..",
        "ooooooooo."
    )
    Log.d("HW03", "Difficult Test 3: ${minPuddles(testCase3)}")
}