import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val tasks = mutableListOf<Task>()
    val pq = PriorityQueue<Task>(compareBy{it.score})
    repeat(n) {
        val (d, s)= br.readLine().split(" ").map{it.toInt()}
        tasks.add(Task(d, s))
    }
    tasks.sortBy{it.due}
    for(t in tasks) {
    pq.offer(t) 
    if(pq.size > t.due) {
        pq.poll()
    }
}
    var ans = 0
    while(pq.isNotEmpty()) ans += pq.poll().score
    println(ans)
}
data class Task(val due: Int, val score: Int)