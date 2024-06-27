fun main() = with(System.`in`.bufferedReader()){
    val num = readLine().toInt()
    val candies = Array(num){ readLine().toCharArray() }

    var answer = findAdja(candies)
    if(answer == num){
        print(answer)
        return
    }

    for(i in 0 until candies.lastIndex){
        for(j in 0 until candies.lastIndex){
            val temp = candies[i][j]
            candies[i][j] = candies[i][j + 1]
            candies[i][j + 1] = temp
            answer = Math.max(answer, findAdja(candies))

            candies[i][j + 1] = candies[i][j]
            candies[i][j] = temp

            candies[i][j] = candies[i + 1][j]
            candies[i + 1][j] = temp
            answer = Math.max(answer, findAdja(candies))

            candies[i + 1][j] = candies[i][j]
            candies[i][j] = temp
        }
        if(answer == num){
            print(answer)
            return
        }
    }

    for(i in 0 until candies.lastIndex){
        var temp = candies[i][candies.lastIndex]
        candies[i][candies.lastIndex] = candies[i + 1][candies.lastIndex]
        candies[i + 1][candies.lastIndex] = temp
        answer = Math.max(answer, findAdja(candies))

        candies[i + 1][candies.lastIndex] = candies[i][candies.lastIndex]
        candies[i][candies.lastIndex] = temp


        temp = candies[candies.lastIndex][i]
        candies[candies.lastIndex][i] = candies[candies.lastIndex][i + 1]
        candies[candies.lastIndex][i + 1] = temp
        answer = Math.max(answer, findAdja(candies))

        candies[candies.lastIndex][i + 1] = candies[candies.lastIndex][i]
        candies[candies.lastIndex][i] = temp
    }


    print(answer)
}

fun findAdja(board: Array<CharArray>): Int{
    var cnt = 1
    var prev = board[0][0]
    var maxCnt = 0

    for(i in board.indices){
        prev = board[i][0]
        for(j in 1 .. board.lastIndex){
            if(board[i][j] == prev){
                cnt++
            } else {
                maxCnt = Math.max(maxCnt, cnt)
                cnt = 1
                prev = board[i][j]
            }
        }
        maxCnt = Math.max(maxCnt, cnt)
        cnt = 1
    }

    for(i in board.indices){
        prev = board[0][i]
        for(j in 1 .. board.lastIndex){
            if(board[j][i] == prev){
                cnt++
            } else {
                maxCnt = Math.max(maxCnt, cnt)
                cnt = 1
                prev = board[j][i]
            }
        }
        maxCnt = Math.max(maxCnt, cnt)
        cnt = 1
    }
    return maxCnt
}