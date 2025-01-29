fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val lists = Array(4) { IntArray(num) }
    var answer = 0L
    repeat(num) { index ->
        val input = reader.readLine()!!.split(" ").map { it.toInt() }
        for(i in 0..3) {
            lists[i][index] = input[i]
        }
    }
    val sumsList = Array(2) { IntArray(num * num) }
    var index = 0
    for(i in 0 until num) {
        for(j in 0 until num) {
            sumsList[0][index] = (lists[0][i] + lists[1][j])
            sumsList[1][index] = (lists[2][i] + lists[3][j])
            index++
        }
    }
    sumsList[0].sort()
    sumsList[1].sort()

    for(sum in sumsList[0]) {
        val upperbound = upperbound(sumsList[1], -sum)
        val lowerbound = lowerbound(sumsList[1], -sum)

        answer += upperbound - lowerbound
    }

    println(answer)
}

fun upperbound(list: IntArray, target: Int): Int {
    var left = 0
    var right = list.size

    while(left < right) {
        val mid = left + (right - left) / 2

        if(list[mid] <= target) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}

fun lowerbound(list: IntArray, target: Int): Int {
    var left = 0
    var right = list.size

    while(left < right) {
        val mid = left + (right - left) / 2

        if(target > list[mid]){
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}