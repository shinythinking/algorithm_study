import java.util.*

fun main() {
    val num = readln().trim().toInt()
    val stones = listOf(-1) + readln().trim().split(" ").map { it.toInt() }
    val (from, to) = readln().trim().split(" ").map { it.toInt() }

    if(from == to) {
        println(0)
        return
    }

    val queue = LinkedList<Int>()
    val visited = IntArray(num + 1)
    queue.add(from)

    while(queue.isNotEmpty()) {
        val currentIdx = queue.poll()
        val step = stones[currentIdx]
        var next = currentIdx + step
        var prev = currentIdx - step
        val nextCnt = visited[currentIdx] + 1

        if((to - currentIdx) % step == 0) {
            println(nextCnt)
            return
        }

        while (next <= num){
            if(visited[next] != 0) {
                next += step
                continue
            }
            queue.add(next)
            visited[next] = nextCnt
            next += step
        }

        while (prev > 0){
            if(visited[prev] != 0) {
                prev -= step
                continue
            }

            queue.add(prev)
            visited[prev] = nextCnt
            prev -= step
        }

    }
    println(-1)
}

val idxList = mutableListOf<Int>()

fun postOrder(left: Int, right: Int) {
    val m = (left + right) / 2
    if(left < right) {
        postOrder(left, m)
        postOrder(m + 1, right)
        idxList.add(m)
    }
}