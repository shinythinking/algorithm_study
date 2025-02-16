import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val costs = Array(num) {
        reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val target = (1 shl num) - 1
    val dp = Array(num) {
        Array(num) {
            IntArray(target + 1) { Int.MAX_VALUE }
        }
    }

    val queue = LinkedList<Triple<Int, Int, Int>>()

    for (i in 0 until num) {
        dp[i][i][0] = 0
    }

    queue.add(Triple(0, 0, 0))
    while (queue.isNotEmpty()) {
        val offered = queue.removeFirst()
        val from = offered.first
        val to = offered.second
        val visited = offered.third

        for ((next, cost) in costs[to].withIndex()) {
            // 갈 수 없는 곳이라면
            if (cost == 0) continue

            // next의 bit
            val bit = (1 shl next)
            // 방문했던 곳이라면 continue
            if (visited and bit == bit) continue
            if (dp[from][next][visited or bit] <= dp[from][to][visited] + cost)
                continue
            dp[from][next][visited or bit] = dp[from][to][visited] + cost
            // 전체를 방문한 것이 아니면 queue에 추가
            if (visited or bit != target) {
                queue.add(Triple(from, next, visited or bit))
            }
        }
    }
    var answer = Int.MAX_VALUE
    for (i in 0 until num) {
        answer = Math.min(answer, dp[i][i][target])
    }
    println(answer)
}