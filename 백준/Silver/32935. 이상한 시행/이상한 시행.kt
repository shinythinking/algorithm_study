import java.util.*

fun main() {
    val n = readln().toInt()
    val q = PriorityQueue<Long>(n)
    val input = readln().split(" ").map {
        it.toLong()
    }
    for(i in input) {
        q.offer(i)
    }

    var sum = input.sum()
    while(-sum > q.peek()) {
        val ori = q.poll()
        q.offer(-sum)
        sum += -sum - ori
    }
    println(sum)
}