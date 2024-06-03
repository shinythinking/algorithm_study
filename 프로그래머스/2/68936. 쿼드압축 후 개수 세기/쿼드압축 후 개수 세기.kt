class Solution {
    data class Pos(
        val row: Int,
        val col: Int
    )
    
    var answer: IntArray = IntArray(2)
    
    fun solution(arr: Array<IntArray>): IntArray {
        Quad(arr, Pos(0, 0), arr.size)
        
        return answer
    }
    
    fun Quad(board: Array<IntArray>, start: Pos, size: Int){
        val standard = board[start.row][start.col]
        var isSame = true
        
        for(i in start.row until start.row + size){
            if(!isSame)
                break
            for(j in start.col until start.col + size){
                if(board[i][j] != standard){
                    isSame = false
                    break
                }
            }
        }
        
        if(isSame){
            answer[standard]++
        } else {
            val halfSize = size / 2
            Quad(board, start, halfSize)
            Quad(board, Pos(start.row + halfSize, start.col), halfSize)
            Quad(board, Pos(start.row, start.col + halfSize), halfSize)
            Quad(board, Pos(start.row + halfSize, start.col + halfSize), halfSize)
        }
        
    }
}