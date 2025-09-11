fun main () {
    val tc = readln().toInt()
    val ans = buildString{
        repeat(tc) {
            val num = readln()
            val l = readln().split(" ").map{it.toInt()}.toMutableList()
            var max = l[0]
            for(i in 1..l.lastIndex) {
                l[i] = Math.max(l[i], l[i-1] + l[i])
                max = Math.max(l[i], max)
            }
            appendLine(max)
        }
    }
    println(ans)
}