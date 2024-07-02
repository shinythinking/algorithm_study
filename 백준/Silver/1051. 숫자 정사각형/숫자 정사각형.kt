fun main() = with(System.`in`.bufferedReader()){
    val (row, col) = readLine().split(' ').map{ it.toInt() }
    val board = Array(row){
        readLine().map{ it - '0' }
    }

    var answer = 1
    for(i in 0 until row - 1){
        for(j in 0 until col - 1){
            val leftUp = board[i][j]
            for(k in j + 1 until col){
                if(board[i][k] == leftUp){
                    val diff = k - j
                    if(i + diff >= row)
                        break
                    if(board[i + diff][j] == board[i + diff][k] && board[i][j] == board[i + diff][j]){
                        answer = Math.max(answer, (diff + 1) * (diff + 1))
                    }
                }
            }
        }
    }
    print(answer)
}