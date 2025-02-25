data class Brick(
    val idx: Int,
    val weight: Int,
    val area: Int,
    val height: Int
)

fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val bricks = arrayOf(Brick(0, 0, 0, 0)) + Array<Brick>(num) { index ->
        val (area, height, weight) = reader.readLine().split(" ").map { it.toInt() }
        Brick(index + 1, weight, area, height)
    }.sortedBy { it.area }

    val dp = IntArray(num + 1)
    dp[1] = bricks[1].height
    var max = dp[1]
    var maxIdx = 1
    for (i in 2..num) {
        dp[i] = bricks[i].height
        for (j in 1 until i) {
            if (bricks[j].weight < bricks[i].weight) {
                dp[i] = Math.max(dp[i], dp[j] + bricks[i].height)
            }
        }
        if (dp[i] > max) {
            max = dp[i]
            maxIdx = i
        }
    }
    val answer = mutableListOf<Int>()
    while (max != 0) {
        if (max == dp[maxIdx]) {
            max -= bricks[maxIdx].height
            answer.add(bricks[maxIdx].idx)
        }
        maxIdx--
    }


    println("${answer.size}\n${answer.reversed().joinToString("\n")}")
}