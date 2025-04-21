fun main() {
    val reader = System.`in`.bufferedReader()
    val tc = reader.readLine().toInt()
    val answer = buildString {
        repeat(tc) {
            val input = reader.readLine().split(" ")
            val num = input[0]
            val students = input.drop(1)
            val avg = students.sumOf { it.toInt() } / num.toDouble()
            val cnt = students.count { it.toInt() > avg }
            appendLine(String.format("%.3f", cnt / num.toDouble() * 100) + "%")
        }
    }
    println(answer)
}