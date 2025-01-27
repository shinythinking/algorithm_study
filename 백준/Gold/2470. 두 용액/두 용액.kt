fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine()!!.toInt()
    val liquid = reader.readLine().split(" ").map { it.toInt() }.sorted()
    var answer: Pair<Int, Int> = Pair(liquid[0], liquid[1])
    if(liquid.first() > 0) {
        answer = Pair(liquid[0], liquid[1])
    } else if(liquid.last() < 0) {
        answer = Pair(liquid[num - 2], liquid[num - 1])
    } else {
        var left = 0
        var right = num - 1
        var absMin = Integer.MAX_VALUE
        while(left < right) {
            val mix = liquid[left] + liquid[right]
            if(Math.abs(mix) < absMin) {
                absMin = Math.abs(mix)
                answer = Pair(liquid[left], liquid[right])
            }

            if(mix > 0) {
                right --
            } else if (mix < 0) {
                left ++
            } else {
                break
            }
        }
    }

    println("${answer.first} ${answer.second}")
}