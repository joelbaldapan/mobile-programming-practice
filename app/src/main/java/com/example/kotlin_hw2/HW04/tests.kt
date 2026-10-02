package com.example.kotlin_hw2.HW04

import android.util.Log
import com.example.kotlin_hw2.HW04.*

// TESTS

fun hw4Problem1() {
    notify("Battery", "Level is low")
    notify("Sync", "Upload finished", "DEBUG")
    notify("Alarm", "Wake up!", times = 3)
    notify(
        message = "Disk almost full",
        title = "Storage",
        level = "WARN"
    )
}

fun hw4Problem2() {
    val scores = listOf(88, 42, 95, 60, 73, 31)

    Log.d("HW04", summarize(scores) { it >= 60 })
    Log.d("HW04", summarize(scores) { it % 2 == 0 })
    Log.d("HW04", summarize(scores, { n -> n > 100 }))
}

fun hw4Problem3() {
    val t = Timer(1, 30, 45)
    Log.d("HW04", "total=${t.totalSeconds}")
    Log.d("HW04", "minutes=${t.asMinutes}")
    Log.d("HW04", t.describe())


    t.totalSeconds = 200
    Log.d("HW04", t.describe())


    t.totalSeconds = -50
    Log.d("HW04", "total=${t.totalSeconds}")
    Log.d("HW04", t.describe())
}

fun hw4Problem4() {
    val shapes = listOf(Rect(3, 4), Triangle(6, 5))

    for (s in shapes) {
        Log.d("HW04", s.describe())
    }
}

fun hw4Problem5() {
    val t1 = Ticket.issue()
    val t2 = Ticket.issue()
    Log.d("HW04", t1.label())
    Log.d("HW04", t2.label())
    Log.d("HW04", "issued so far: ${Counter.count}")
    val t3 = Ticket.issue()
    Log.d("HW04", t3.label())
    Log.d("HW04", "issued so far: ${Counter.count}")
}

fun hw4Problem6() {
    val activeCanvas = listOf(Rect(3, 4), Triangle(6, 5))
    val emptyCanvas: List<Shape> = emptyList()

    evaluateCanvas(activeCanvas)  // result exists
    evaluateCanvas(emptyCanvas)   // no result exists
}