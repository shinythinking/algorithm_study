fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val strAns = buildString {
        repeat(num) {
            val life = reader.readLine().split(" ")
            var answer = 0
            for (str in life) {
                for (ch in str) {
                    answer += (ch - 'A') + 1
                }
            }
            appendLine(if(answer == 100) "PERFECT LIFE" else answer)
        }
    }
    println(strAns)
}