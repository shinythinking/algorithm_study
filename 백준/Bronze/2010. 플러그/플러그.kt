fun main () {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    var answer = 0
    repeat(num) {
        answer += reader.readLine().toInt()
    }
    println(answer - num + 1)
}