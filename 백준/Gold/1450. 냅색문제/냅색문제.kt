fun main() {
    val reader = System.`in`.bufferedReader()
    val (n, c) = reader.readLine().split(" ").map { it.toInt() }
    val things = reader.readLine().split(" ").map { it.toInt() }
    val middle = n / 2
    val firstGroup = mutableListOf<Int>()
    val secondGroup = mutableListOf<Int>()

    getSums(0, 0, middle, things, firstGroup, c)
    getSums(0, middle, n, things, secondGroup, c)
    firstGroup.sort()
    secondGroup.sort()
    var first = 0
    var second = 0
    var answer = 0

    for (i in 0..firstGroup.lastIndex) {
        answer += getUpperBound(secondGroup, c - firstGroup[i])
    }

    println(answer)
}

fun getUpperBound(list: List<Int>, target: Int): Int {
    var left = 0
    var right = list.size
    while (left < right) {
        val mid = (left + right) / 2

        if(list[mid] > target) {
            right = mid
        } else {
            left = mid + 1
        }
    }

    return left
}

fun getSums(sum: Int, cur: Int, end: Int, group: List<Int>, sums: MutableList<Int>, limit: Int) {
    if (cur == end) {
        sums.add(sum)
        return
    }

    val temp = sum + group[cur]
    if (temp in 0..limit) {
        getSums(temp, cur + 1, end, group, sums, limit)
    }
    getSums(sum, cur + 1, end, group, sums, limit)
}