class Solution {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        val flights = mutableListOf<Ticket>()
        for(t in tickets){
            flights.add(Ticket(t[0], t[1]))
        }
        flights.sortWith(compareBy({it.from}, {it.to}))
        val visited = BooleanArray(flights.size) { false }
        val ans = Array<String>(flights.size+1) {""}
        
        fun dfs(visited: BooleanArray, prev: String, depth: Int): Boolean {
            if(depth == visited.size){
                ans[depth] = prev
                return true
            }
            for(i in 0..visited.lastIndex) {
                if(visited[i]) continue
                if(flights[i].from != prev) continue
                visited[i] = true
                if(dfs(visited, flights[i].to, depth + 1)) {
                    ans[depth] = prev
                    return true
                }
                visited[i] = false

            }
            return false
        }
        dfs(visited, "ICN", 0)
        return ans

    }
}
data class Ticket(val from: String, val to: String)