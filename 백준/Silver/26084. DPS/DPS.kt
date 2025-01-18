fun main() {
    val reader = System.`in`.bufferedReader()
    var answer = 1L
    val abbr = reader.readLine()
    val num = reader.readLine().toInt()
    val targetArray = IntArray(26)
    val countArray = IntArray(26)
    repeat(num) {
        countArray[reader.readLine().first() - 'A']++
    }

    for (ch in abbr) {
        targetArray[ch - 'A']++
    }

    for (i in targetArray.indices) {
        if(targetArray[i] != 0) {
            answer *= combi(countArray[i].toLong(), targetArray[i].toLong())
        }
    }

    println(answer)
}

fun combi(n: Long, k: Long): Long {
    if(n < k) return 0L
    val num = k.coerceAtMost(n - k)
    var result = 1L
    for (i in 1..num) {
        result = result * (n - i + 1) / i
    }
    return result
}