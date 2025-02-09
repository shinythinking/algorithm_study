import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val (num, place, road) = reader.readLine().split(" ").map { it.toInt() }
    val from = reader.readLine().split(" ").map { it.toInt() }
    val to = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    var answer = 0

    val roads = Array(place + 1) {
        mutableListOf<Pair<Int, Int>>()
    }
    repeat(road) {
        val (n1, n2, cost) = reader.readLine().split(" ").map { it.toInt() }
        roads[n1].add(Pair(n2, cost))
        roads[n2].add(Pair(n1, cost))
    }

    answer += dijkstra(place, roads, from[0], to)
    answer += dijkstra(place, roads, from[1], to)
    println(answer)
}

fun dijkstra(num: Int, roads: Array<MutableList<Pair<Int, Int>>>, from: Int, to: IntArray): Int {
    val dist = Array(num + 1) { Int.MAX_VALUE }

    val comp = Comparator<Pair<Int, Int>> { o1, o2 -> o1.second - o2.second }
    val pq = PriorityQueue<Pair<Int, Int>>(comp)

    dist[from] = 0
    pq.offer(Pair(from, 0))
    while (pq.isNotEmpty()) {
        val polled = pq.poll()
        val cur = polled.first
        val cost = polled.second

        if(cost > dist[cur]) continue

        for (next in roads[cur]) {
            val newCost = dist[cur] + next.second
            if (newCost < dist[next.first]) {
                dist[next.first] = newCost
                pq.offer(Pair(next.first, newCost))
            }
        }
    }

    var answer = 0
    for(i in to) {
        answer += dist[i]
    }
    return answer
//    return dist.filterIndexed { index, _ ->
//        to.contains(index)
//    }.sumOf { if (it == Int.MAX_VALUE) -1 else it }
}