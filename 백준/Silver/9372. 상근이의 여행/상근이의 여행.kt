fun main() {
    val reader = System.`in`.bufferedReader()
    val testcase = reader.readLine().toInt()
    var index = -1
    val answer = IntArray(testcase)
    repeat(testcase) {
        index++
        val (num, plane) = reader.readLine().split(" ").map { it.toInt() }
        answer[index] = num - 1
        repeat(plane) {
            reader.readLine()
        }
    }
    println(answer.joinToString("\n"))
}