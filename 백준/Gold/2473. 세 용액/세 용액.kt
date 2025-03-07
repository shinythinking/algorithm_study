fun main() {
    val reader = System.`in`.bufferedReader()
    val size = reader.readLine().toInt()
    val liquids = reader.readLine().split(" ").map { it.toLong() }.sorted().toLongArray()
    var answer = Long.MAX_VALUE
    var ans = Triple(0L, 0L, 0L)

    for (fix in 0..size - 3) {
        val fixedOne = liquids[fix]
        var left = fix + 1
        var right = liquids.lastIndex

        while (left < right) {
            val sum = fixedOne + liquids[left] + liquids[right]
            val abs = Math.abs(sum)
            if (abs < answer) {
                answer = abs
                ans = Triple(fixedOne, liquids[left], liquids[right])
            }
            if (sum > 0) {
                right --
            } else if (sum < 0) {
                left ++
            } else {
                println("${ans.first} ${ans.second} ${ans.third}")
                return
            }
        }
    }

    println("${ans.first} ${ans.second} ${ans.third}")
}