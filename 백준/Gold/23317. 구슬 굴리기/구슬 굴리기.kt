package shinythinking

import kotlin.math.pow
import kotlin.time.times

fun main() {
    val row = readln().toInt()
    val hurdleNum = readln().toInt()
    val hurdles = Array<Pair<Int, Int>>(hurdleNum) {
        val (r, c) = readln().split(" ").map { it.toInt() }
        Pair(r, c)
    }.distinct().sortedBy { it.first }

    if(hurdles.size > row) return println("0")

    var curPos = Pair(0, 0)
    var answer = 1

    for(hurdle in hurdles) {
        if(curPos.second > hurdle.second) return println("0")

        val rDif = hurdle.first - curPos.first
        val cDif = hurdle.second - curPos.second

        if(rDif < cDif) return println("0")

        answer *= combination(rDif, cDif)

        curPos = hurdle
    }

    answer *= (2.0).pow((row - 1) - curPos.first).toInt()
    println(answer)
}

fun combination(n: Int, k: Int): Int {
    if (k == 0 || k == n) return 1
    var result = 1
    for (i in 1..k) {
        result = result * (n - i + 1) / i
    }
    return result
}