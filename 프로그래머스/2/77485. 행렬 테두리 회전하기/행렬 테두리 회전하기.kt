

class Solution {
    data class Pos(val row: Int, val col: Int)
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        val board = Array(rows){ row ->
            IntArray(columns){ col ->
                row * columns + col + 1
            }
        }
        
        for(query in queries){
            val startR = query[0] - 1
            val startC = query[1] - 1
            val endR = query[2] - 1
            val endC = query[3] - 1
            
            var min = 100000
            var currentV = board[startR][startC]
            var nextV = board[startR][startC]
            for(i in startC + 1 .. endC){
                currentV = nextV
                nextV = board[startR][i]
                board[startR][i] = currentV
                min = Math.min(min, nextV)
            }
            
            for(i in startR + 1..endR){
                currentV = nextV
                nextV = board[i][endC]
                board[i][endC] = currentV
                min = Math.min(min, nextV)
            }
            
            for(i in endC - 1 downTo startC){
                currentV = nextV
                nextV = board[endR][i]
                board[endR][i] = currentV
                min = Math.min(min, nextV)
            }
            
            for(i in endR - 1 downTo startR){
                currentV = nextV
                nextV = board[i][startC]
                board[i][startC] = currentV
                min = Math.min(min, nextV)
            }
            answer += min
        }
        
        return answer
    }
}