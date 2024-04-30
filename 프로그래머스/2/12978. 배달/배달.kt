import java.util.*

class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val graph: MutableMap<Int, MutableMap<Int, Int>> = mutableMapOf() 
        for(ro in road) {
            graph.putIfAbsent(ro[0], mutableMapOf())
            graph.putIfAbsent(ro[1], mutableMapOf())
            graph[ro[0]]!![ro[1]] = Math.min(ro[2], graph[ro[0]]!!.getOrDefault(ro[1],1000000))
            graph[ro[1]]!![ro[0]] = graph[ro[0]]!![ro[1]]!!
        }
        val pq = PriorityQueue<Map.Entry<Int, Int>>(compareBy { (node, time) -> time })
        val dist = mutableMapOf<Int, Int>()
        pq.offer(AbstractMap.SimpleEntry(1, 0))

        while(pq.isNotEmpty()){
            val(cur, cost) = pq.poll()

            if(cost > k)
                break

            if(!dist.containsKey(cur)){
                dist[cur] = cost
                if(!graph.containsKey(cur))
                    continue
                for ((next, nextCost) in graph[cur]!!) {
                    pq.offer(AbstractMap.SimpleEntry(next, cost + nextCost))
                }
            }
        }
        val answer = dist.keys.size
        return answer
    }
}