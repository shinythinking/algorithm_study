fun main() {
    val tc = readln().toInt()
    val ans = buildString{
        repeat(tc) {
            val tmp = readln().toInt()
            appendLine("=".repeat(tmp))
        }
    }
    println(ans)
}