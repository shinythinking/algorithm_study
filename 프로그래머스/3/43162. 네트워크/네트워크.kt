class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        
        val visited = BooleanArray(n)
        
        fun dfs(current: Int) {
            if(visited[current]) return
            visited[current] = true
            
            for((i, v) in computers[current].withIndex()) {
                if(v == 0) continue
                if(visited[i])  continue
                dfs(i)
            }
        }
        
        for(i in 0 until n) {
            if(!visited[i]){
                dfs(i)
                answer++
            }
        }
        
        
        return answer
    }
}