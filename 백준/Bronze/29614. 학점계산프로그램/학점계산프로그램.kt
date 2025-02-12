fun main() {
    val reader = System.`in`.bufferedReader()
    val score = reader.readLine()
    var answer = 0.0
    var cnt =0
    for(ch in score) {
        answer += when(ch) {
            'A' -> 4.0
            'B' -> 3.0
            'C' -> 2.0
            'D' -> 1.0
            'F' -> 0.0
            else -> {
                cnt++
                0.5
            }
        }
    }
    println(answer / (score.length - cnt))
}