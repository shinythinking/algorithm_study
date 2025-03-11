fun main() {
    val reader = System.`in`.bufferedReader()
    val dp = Array(51) {
        Array(51) {
            IntArray(51) { Int.MAX_VALUE }
        }
    }
    val answer = buildString {
        while (true) {
            val (a, b, c) = reader.readLine().split(" ").map { it.toInt() }
            if (a == -1 && b == -1 && c == -1) break
            fun solve(a: Int, b: Int, c: Int): Int {
                return if (a <= 0 || b <= 0 || c <= 0) 1
                else if (dp[a][b][c] != Int.MAX_VALUE) dp[a][b][c]
                else if (a > 20 || b > 20 || c > 20) {
                    dp[a][b][c] = solve(20, 20, 20)
                    dp[a][b][c]
                } else if (b in (a + 1)..<c) {
                    dp[a][b][c] = solve(a, b, c - 1) + solve(a, b - 1, c - 1) - solve(a, b - 1, c)
                    dp[a][b][c]
                } else {
                    dp[a][b][c] = solve(a - 1, b, c) + solve(a - 1, b - 1, c) + solve(a - 1, b, c - 1) - solve(a - 1, b - 1, c - 1)
                    dp[a][b][c]
                }
            }
            appendLine("w($a, $b, $c) = ${solve(a, b, c)}")
        }
    }
    println(answer)
}