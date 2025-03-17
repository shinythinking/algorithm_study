fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val stack = ArrayDeque<Pair<Long, Int>>()
    val arr = Array(num) {
        reader.readLine().toLong()
    }

    var answer = 0L
    for (n in arr) {
        val last = stack.lastOrNull() ?: (Long.MAX_VALUE to 0)

        if (last.first == n) {
            stack.removeLast()
            answer += last.second
            if (stack.isNotEmpty()) answer += 1
            stack.addLast(Pair(n, last.second + 1))
        } else if (last.first > n) {
            if (last.first != Long.MAX_VALUE) answer += 1
            stack.addLast(Pair(n, 1))
        } else {
            var pop = stack.last()
            while (pop.first < n) {
                pop = stack.removeLastOrNull() ?: break
                answer += pop.second
                pop = stack.lastOrNull() ?: (Long.MAX_VALUE to 0)
            }
            if (pop.first == n) {
                val pop1 = stack.removeLast()
                answer += pop1.second
                if (stack.isNotEmpty()) answer += 1
                stack.addLast(Pair(n, pop1.second + 1))
            } else if (pop.first > n) {
                if (pop.first != Long.MAX_VALUE) answer += 1
                stack.addLast(Pair(n, 1))
            }
        }
    }
    println(answer)
}