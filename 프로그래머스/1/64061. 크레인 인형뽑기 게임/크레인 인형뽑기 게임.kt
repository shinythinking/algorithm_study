import java.util.*

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val towers = Array(board[0].size + 1){ LinkedList<Int>() }
        val basket = ArrayDeque<Int>()
        
        for(floor in board){
            for((i, doll) in floor.withIndex()){
                if(doll == 0)
                    continue
                towers[i + 1].offer(doll)
            }
        }
        
        var answer = 0
        
        for(move in moves){
            if(towers[move].isNotEmpty()){
                val doll = towers[move].poll()
                if(doll == basket.peek() ?: -1){
                    basket.pop()
                    answer += 2
                } else {
                    basket.push(doll)
                }
            }
        }
        
        return answer
    }
}