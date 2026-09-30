package com.example.kotlin_hw2.HW04

import android.util.Log

fun notify(title: String, message: String,
           level: String="INFO", times: Int=1) {
    for (i in 1..times) {
        Log.d("HW04", "[$level] $title: $message")
    }
}

fun summarize(scores: List<Int>, func: (Int) -> Boolean): String {
    val filtered = scores.filter(func)
    return "${filtered.size} values, sum=${filtered.sum()}"
}

class Timer(hour: Int, minute: Int, second: Int) {
    var totalSeconds: Int = 0
        set(value) { field = if (value < 0) 0 else value }

    init { totalSeconds = (hour*3600) + (minute*60) + second }

    val asMinutes: Int
        get() = totalSeconds / 60

    fun describe(): String {
        return "Timer of $totalSeconds s ($asMinutes min)"
    }
}

// use `open` so that it can be inherited from
open class Shape(val name: String) {
    init { Log.d("HW04", "Shape init: $name") }

    open fun area(): Int { return 0 }

    fun describe(): String {
        return "$name area=${area()}"
    }
}
class Rect(val w: Int, val h: Int) : Shape("Rect") {
    override fun area(): Int { return w*h }
}
class Triangle(val b: Int, val h: Int) : Shape("Triangle") {
    override fun area(): Int { return (b*h)/2 }
}

object Counter {
    var count: Int = 0
    fun next(): Int {
        count++
        return count
    }
}

class Ticket(val id: Int) {
    companion object {
        const val PREFIX = "TK"

        fun issue(): Ticket {
            return Ticket(Counter.next())
        }
    }

    fun label(): String {
        return "$PREFIX-id"
    }
}

// function that can return  nullable `Shape`
fun findLargestShape(shapes: List<Shape>): Shape? {
    if (shapes.isEmpty()) return null
    return shapes.maxByOrNull { it.area() }
}
fun evaluateCanvas(canvas: List<Shape>) {
    // `also` returns the context object
    canvas.also {
        Log.d("HW04", "Analyzing canvas with ${it.size} shapes...")
    }

    val largestShape = findLargestShape(canvas)

    // `let` executes only if largestShape is not null.
    //       else, it executes the fallback
    largestShape?.let {
        Log.d("HW04", "Found the largest shape: ${it.describe()}")
    } ?: Log.d("HW04", "Canvas is completely empty. No shapes found.")
}


// TESTS

fun hw4_problem1() {
    notify("Battery", "Level is low")
    notify("Sync", "Upload finished", "DEBUG")
    notify("Alarm", "Wake up!", times = 3)
    notify(
        message = "Disk almost full",
        title = "Storage",
        level = "WARN"
    )
}

fun hw4_problem2() {
    val scores = listOf(88, 42, 95, 60, 73, 31)

    Log.d("HW04", summarize(scores) { it >= 60 })
    Log.d("HW04", summarize(scores) { it % 2 == 0 })
    Log.d("HW04", summarize(scores, { n -> n > 100 }))
}

fun hw5_problem3() {
    val shapes = listOf(Rect(3, 4), Triangle(6, 5))

    for (s in shapes) {
        Log.d("HW04", s.describe())
    }
}

fun hw5_problem4() {
    val t1 = Ticket.issue()
    val t2 = Ticket.issue()
    Log.d("HW04", t1.label())
    Log.d("HW04", t2.label())
    Log.d("HW04", "issued so far: ${Counter.count}")
    val t3 = Ticket.issue()
    Log.d("HW04", t3.label())
    Log.d("HW04", "issued so far: ${Counter.count}")
}

fun hw5_problem6() {
    val activeCanvas = listOf(Rect(3, 4), Triangle(6, 5))
    val emptyCanvas: List<Shape> = emptyList()

    evaluateCanvas(activeCanvas)  // result exists
    evaluateCanvas(emptyCanvas)   // no result exists
}