fun main() {
    val reader = System.`in`.bufferedReader()

    fun cantor(num: Int): String {
        if(num == 0) return "-"

        val prev = cantor(num - 1)
        val space = " ".repeat(prev.length)
        return prev + space + prev
    }

    val answer = buildString{
        while (true) {
            val input = reader.readLine() ?: break
            appendLine(cantor(input.toInt()))
        }
    }
    println(answer)
}