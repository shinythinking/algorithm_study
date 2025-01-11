import kotlin.math.max


fun main() {
    val reader = System.`in`.bufferedReader()
    var testCase = reader.readLine().toInt()
    val answer = buildString {
        while (testCase --> 0) {
            val num = reader.readLine().toInt()
            val listOfDiamond = List(num) {
                val (w, c) = reader.readLine().split(" ").map { it.toDouble() }
                Pair(w, c)
            }
            val dp = IntArray(num) { 1 }
            dp[0] = 1
            for((i, dia) in listOfDiamond.withIndex()) {
                for(j in i - 1 downTo 0) {
                    if(isSecondDiaBetter(listOfDiamond[j], dia)){
                        dp[i] = max(dp[i], dp[j] + 1)
                    }
                }
            }
            appendLine(dp.max())
        }
    }
    println(answer)
}

fun isSecondDiaBetter(first: Pair<Double, Double>, second: Pair<Double, Double>): Boolean {
    return first.first < second.first && first.second > second.second
}
