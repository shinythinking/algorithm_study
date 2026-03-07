import java.util.*
fun main() {
    val br = System.`in`.bufferedReader()
    val tc = br.readLine().toInt()
    repeat(tc) {
        val (n, d, h) = br.readLine().split(" ").map{it.toInt()}
        val adjList = Array(n + 1){
            mutableListOf<Pair<Int, Int>>()
        }
        repeat(d) {
            val (to, from, c) = br.readLine().split(" ").map{it.toInt()}
            adjList[from].add(Pair(to, c))
        }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy{it.second})
        val dist = IntArray(n + 1){Int.MAX_VALUE}
        dist[h] = 0
        pq.offer(h to 0)
        
        while(pq.isNotEmpty()) {
            val polled = pq.poll()
            if(dist[polled.first] < polled.second) continue
            for(next in adjList[polled.first]){
                if(next.second + polled.second < dist[next.first]) {
                    dist[next.first] = next.second + polled.second
                    pq.offer(next.first to dist[next.first])
                }
            }
        }
        var ansMax = 0
        var ansCnt = 0
        for(d in dist) {
            if(d != Int.MAX_VALUE) {
                ansCnt++
                if(ansMax<d) ansMax = d
            }
        }
        println("$ansCnt $ansMax")
 
        
    }
}
