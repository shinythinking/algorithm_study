class Solution {
    lateinit var board: Array<IntArray>
    
    fun solution(n: Int): IntArray {
        if(n == 1) return intArrayOf(1)
        board = Array(n){ IntArray(n) }
        
        var total = 0
        for(i in 1..n)
            total += i
        
        var idx = 1
        var col = 0
        var row = 0
        
        while(idx <= total){
            while(row < n){
                if(board[row][col] == 0){
                    board[row++][col] = idx++
                } else
                    break
            }
            row --
            col++
            
            while(col < n){
                if(board[row][col] == 0){
                    board[row][col++] = idx++
                }else
                    break
            }
            col--
            
            while(true){
                row--
                col--
                if(board[row][col] == 0){
                    board[row][col] = idx++
                } else {
                    row++
                    col++
                    break
                }
            }
            row++
        }
        
        var answer = IntArray(total)
        idx = 0
        for(i in board){
            for(j in i){
                if(j == 0)
                    continue
                answer[idx++] = j
            }
        }
        
        return answer
    }
}