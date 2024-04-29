class Solution {
    var answer = 0
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        dfs(dungeons, BooleanArray(dungeons.size), 0, k )
        return answer
    }
    fun dfs(dungeons: Array<IntArray>, visited: BooleanArray, cnt: Int, hp: Int){
        
        for(i in dungeons.indices){
            if(visited[i] || dungeons[i][0] > hp)
                continue
            if(dungeons[i][1] > hp)
                continue
            visited[i] = true
            dfs(dungeons, visited, cnt + 1, hp - dungeons[i][1])
            visited[i] = false
            
        }
        answer = Math.max(answer, cnt)
        
    }
}