class Solution {
    fun solution(board: Array<String>): Int {
        var bingoO = 0
        var bingoX = 0
        var cntO = 0
        var cntX = 0
        
        for(row in board){
            if(row == "XXX")
                bingoX ++
            else if(row == "OOO")
                bingoO ++
            
            for(e in row){
                if(e == 'O')
                    cntO++
                else if(e == 'X')
                    cntX++
             }
         }
        
        if(cntO < cntX)
            return 0
        
        if(cntO > cntX && cntO != cntX + 1)
            return 0
        
        
        for(i in 0 .. 2){
            if(board[0][i] != '.'){
                if(board[1][i] == board[2][i]){
                    if(board[0][i] == board[1][i]){
                        if(board[0][i] == 'X')
                            bingoX++
                        else
                            bingoO++
                    }
                }
            }
        }
        
        if(board[1][1] != '.'){
            if(board[0][0] == board[1][1]){
                if(board[2][2] == board[1][1]){
                    if(board[0][0] == 'X')
                        bingoX++
                    else 
                        bingoO++
                }
            }
            if(board[0][2] == board[1][1]){
                if(board[2][0] == board[1][1]){
                    if(board[1][1] == 'X')
                        bingoX++
                    else 
                        bingoO++
                }
            }
        }
        
        if(bingoX + bingoO == 2){
            if(bingoX == 1)
                return 0
        }
        if(cntO == 5 && bingoX == 1)
            return 0
        if(bingoX == 1 && cntX < cntO)
            return 0
        if(bingoO == 1 && cntX == cntO)
            return 0
        return 1
        
        
        
        
        
    }
}