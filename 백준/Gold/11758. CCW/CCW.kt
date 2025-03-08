fun main() {
    val reader = System.`in`.bufferedReader()
    val (x1, y1) = reader.readLine().split(" ").map { it.toInt() }
    val (x2, y2) = reader.readLine().split(" ").map { it.toInt() }
    val (x3, y3) = reader.readLine().split(" ").map { it.toInt() }

    fun ccw(a: Pair<Int, Int>, b: Pair<Int, Int>, c: Pair<Int, Int>): Int {
        val s = (a.first * b.second + b.first * c.second + c.first * a.second) - (a.second * b.first + b.second * c.first + c.second * a.first)

        if(s > 0) return 1
        else if(s < 0) return -1
        else return 0
    }

    println(ccw(Pair(x1, y1), Pair(x2, y2), Pair(x3, y3)))
}