fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val target = listOf("TTT", "TTH", "THT", "THH", "HTT", "HTH", "HHT", "HHH")
    val answer = buildString {
        repeat(num) {
            val arr = reader.readLine()
            val ans = IntArray(8)
            var start = 0
            var end = 2
            while (end < arr.length) {
                val c = arr.slice(start .. end)
                ans[target.indexOf(c)]++
                start ++
                end ++
            }
            appendLine(ans.joinToString(" "))
        }
    }

    println(answer)
}