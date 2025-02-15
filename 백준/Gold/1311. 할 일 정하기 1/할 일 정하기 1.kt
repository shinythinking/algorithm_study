fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val tmp = Array(num) {
        intArrayOf(0) + reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val cost = Array(1) { IntArray(num + 1) } + tmp
    val memo = Array(num + 1) {
        IntArray(1 shl (num + 1)) { Int.MAX_VALUE }
    }

    memo[0][0] = 0

    for(i in 1..num) {
        for(j in 0 until (1 shl (num + 1))) {
            if(memo[i - 1][j] == Int.MAX_VALUE) continue

            for(k in 1..num) {
                if(j and (1 shl k) != 0) continue
                memo[i][j or (1 shl k)] = Math.min(memo[i][j or (1 shl k)], memo[i - 1][j] + cost[i][k])
            }
        }
    }
    println(memo[num][(1 shl (num + 1)) - 2])
}