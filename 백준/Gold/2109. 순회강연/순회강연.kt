import java.util.*
fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val ll = mutableListOf<Lecture>()
    val pq = PriorityQueue<Lecture>(compareBy{it.price})
    repeat(n) {
        val (p, d) = br.readLine().split(" ").map{it.toInt()}
        ll.add(Lecture(p,d))
    }
    ll.sortBy{it.due}
    var ans = 0

    for(lec in ll) {
        if(pq.size<lec.due) pq.offer(lec)
        else {
            val t = pq.peek()
            if(t.price < lec.price){
            pq.poll()
            pq.offer(lec)
            }
        }
    }
    while(pq.isNotEmpty()) ans += pq.poll().price
    println(ans)
}
data class Lecture (val price: Int, val due: Int)