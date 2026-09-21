package com.example.kotlin_hw2.HW03

import android.util.Log

class RoyalLineage(founder: String) {
    // memoize the distance from the founder for instant O(1) `generationsFromFounder` lookups
    private val distances = mutableMapOf<String, Int>()
    init {
        // the root node (founder) is exactly 0 steps away from themselves
        distances[founder] = 0
    }
    fun addDescendant(newDescendant: String, parent: String) {
        val parentDistance = distances[parent]
        // if the parent exists, the new descendant's distance is the parent's + 1
        if (parentDistance != null) {
            distances[newDescendant] = parentDistance + 1
        }
    }
    fun generationsFromFounder(name: String): Int? {
        return distances[name] // just make use of the distances hashmap
    }
}

fun testMedium() {
    val tree = RoyalLineage("Taejo")
    // Test Case 1: Standard Tree
    tree.addDescendant("Taejong", "Taejo")
    tree.addDescendant("Sejong", "Taejong")
    tree.addDescendant("Munjong", "Sejong")
    Log.d("HW03", "Medium Test 1: ${tree.generationsFromFounder("Munjong")}")
    // Expected output: 3

    // Test Case 2: Unknown
    tree.addDescendant("Sejo", "Sejong")
    Log.d("HW03", "Medium Test 2: ${tree.generationsFromFounder("Joel")}")
    // Expected output: null

    // Test Case 3: 100,000 operations test
    var currentParent = "Taejo"
    for (i in 1..100_000) {
        val newDescendant = "Royal_$i"
        tree.addDescendant(newDescendant, currentParent)
        currentParent = newDescendant
    }
    val target = "Royal_100000"
    for (j in 1..100_000) { tree.generationsFromFounder(target) }
    val generations = tree.generationsFromFounder(target)
    Log.d("HW03", "Medium Test 3: Distance for $target is $generations")
    // Expected output: It should not freeze.
}