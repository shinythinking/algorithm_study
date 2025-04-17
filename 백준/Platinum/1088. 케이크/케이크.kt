import java.util.*

data class Element(
    val origin: Double,
    val divide: Int,
    val data: Double
)

fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val cakes = reader.readLine().split(" ").map { it.toDouble() }
    var cut = reader.readLine().toInt()
    val comp = Comparator<Element> { o1, o2 ->
        o2.data.compareTo(o1.data)
    }
    val pq = PriorityQueue<Element>(comp)
    var min = Double.MAX_VALUE
    var answer = Double.MAX_VALUE
    repeat(num) { i ->
        min = minOf(cakes[i], min)
        pq.offer(Element(cakes[i], 1, cakes[i]))
    }

    while (cut-- > 0) {
        val big = pq.poll()
        answer = minOf(answer, big.data - min)
        val newE = Element(big.origin, big.divide + 1, big.origin / (big.divide + 1))
        pq.offer(newE)

        min = minOf(newE.data, min)
    }

    answer = minOf(answer, pq.peek().data - min)
    println(answer)
}