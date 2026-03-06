class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        val visited = IntArray(n + 1){0}
        val queue = ArrayDeque<Pair<Int, Int>>()
        var m = 0
        queue.addLast(1 to 1)
        visited[1] = 1
        val linked = Array( n + 1){
            mutableListOf<Int>()
        }
        for(e in edge) {
            val from = e[0]
            val to = e[1]
            linked[from].add(to)
            linked[to].add(from)
        }
        
        while(queue.isNotEmpty()) {
            val offered = queue.removeFirst()
            for(next in linked[offered.first]) {
                if(visited[next] != 0) continue
                visited[next] = offered.second + 1
                queue.addLast(next to (offered.second + 1))
                if(m < visited[next]) m = visited[next]
            }
        }
    
        
        // var ans = visited.count(m)
        var ans = 0
        for(i in 1..n) {
            if(visited[i] == m) ans++
        }
        return ans
    }
}