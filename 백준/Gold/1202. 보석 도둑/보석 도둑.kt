import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val (gem, bag) = reader.readLine().split(" ").map { it.toInt() }
    val gems = Array<Pair<Int, Int>>(gem) { Pair(0, 0) }
    val bags = IntArray(bag)
    repeat(gem) { i ->
        val (weight, price) = reader.readLine()!!.split(" ").map { it.toInt() }
        gems[i] = weight to price
    }
    repeat(bag) { i ->
        bags[i] = reader.readLine().toInt()
    }
    gems.sortBy { it.first }
    bags.sort()
    val comp = Comparator<Int> { a, b ->
        b - a
    }
    val pq = PriorityQueue<Int>(comp)
    var cur = 0
    var answer = 0L

    for (w in bags) {
        while (cur <= gems.lastIndex && gems[cur].first <= w) {
            pq.offer(gems[cur].second)
            cur++
        }

        if(pq.isNotEmpty()){
            answer += pq.poll()
        }
    }

    println(answer)
}