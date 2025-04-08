fun main() {
    val reader = System.`in`.bufferedReader()
    val input = reader.readLine()
    val target = reader.readLine()
    var answer = false
    fun solve(text: String) {
        if (answer || text.length == input.length) {
            if (text == input) answer = true
            return
        }
        if (text[0] == 'B') {
            solve(text.reversed().dropLast(1))
        }
        if (text.last() == 'A') {
            solve(text.dropLast(1))
        }
    }
    solve(target)
    println(if (answer) 1 else 0)
}