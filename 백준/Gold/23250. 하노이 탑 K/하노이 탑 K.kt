import kotlin.math.pow

fun main() {
    val reader = System.`in`.bufferedReader()
    val (num, t) = reader.readLine()!!.split(' ').map { it.toLong() }

    var target = t
    fun hanoi(from: Int, by: Int, to: Int, num: Int) {
        val mid = 2.0.pow(num - 1).toLong()
        if (target < mid) {
            hanoi(from, to, by, num - 1)
        } else if (target == mid) {
            println("$from $to")
            return
        } else {
            target -= mid
            hanoi(by, from, to, num - 1)
        }
    }
    hanoi(1, 2, 3, num.toInt())
}