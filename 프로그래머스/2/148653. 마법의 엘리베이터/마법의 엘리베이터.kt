import java.util.*

class Solution {
    val answer = PriorityQueue<Int>()
    fun solution(storey: Int): Int {
        dfs(storey, 0)
        return answer.poll()
    }
    fun dfs(storey: Int, cnt: Int){
        if(storey == 0){
            answer.offer(cnt)
            return
        }
        if(storey == 1){
            answer.offer(cnt + 1)
            return
        }
        
        val lower = storey % 10
        val upper = 10 - lower
        dfs((storey - lower) / 10, cnt + lower)
        dfs((storey + upper) / 10, cnt + upper)
    }
}