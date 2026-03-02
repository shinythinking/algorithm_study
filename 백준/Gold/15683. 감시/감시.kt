fun main() {
    val br = System.`in`.bufferedReader()
    var ans = 111111111
    val (row,col) = br.readLine().split(" ").map{it.toInt()}
    var board = Array(row) {
        br.readLine().split(" ").map{it.toInt()}.toIntArray()
    }

    fun watch(b: Array<IntArray>
              ,r: Int, c: Int,
              left: Boolean, right: Boolean,
              u: Boolean, d: Boolean): Array<IntArray> {
        val newB = Array(b.size) { i ->
            b[i].clone()
        }
        if(left){
            for(i in c - 1 downTo 0) {
                if(newB[r][i] == 6) break
                if(newB[r][i] in 1..5) continue
                newB[r][i] = 9
            }
        }
        if(right) {
            for(i in c + 1 until col){
                if(newB[r][i] == 6) break
                if(newB[r][i] in 1..5) continue
                newB[r][i] = 9
            }
        }
        if(u) {
            for(i in r - 1 downTo 0){
                if(newB[i][c] == 6) break
                if(newB[i][c] in 1..5) continue
                newB[i][c] = 9
            }

        }
        if(d) {
            for(i in r + 1 until row){
                if(newB[i][c] == 6) break
                if(newB[i][c] in 1..5) continue
                newB[i][c] = 9
            }
        }

        return newB
    }

    val queue = mutableListOf<Pair<Int, Int>>()
    for(i in 0 until row) {
        for(j in 0 until col) {
            if(board[i][j] in 1..4) {
                queue.add(i to j)
            } else if(board[i][j] == 5) {
                board = watch(board, i, j, true, true, true, true)
            }
        }
    }

    fun dfs(board: Array<IntArray>, idx: Int) {
        if(idx >= queue.size) {
            var cnt = 0
            for(i in 0 until row){
                for(j in 0 until col) {
                    if(board[i][j] == 0) cnt ++
                }
            }
            ans = Math.min(ans, cnt)
            return
        }
        val point = queue[idx]

        when(board[point.first][point.second]){
            1 -> {
                dfs(watch(board, point.first, point.second, true, false, false, false ), idx + 1)
                dfs(watch(board, point.first, point.second, false, true, false, false ), idx + 1)
                dfs(watch(board, point.first, point.second,  false, false,true, false ), idx + 1)
                dfs(watch(board, point.first, point.second, false, false, false,true ), idx + 1)
            }
            2 -> {
                dfs(watch(board, point.first, point.second, false, false, true, true ), idx + 1)
                dfs(watch(board, point.first, point.second, true, true, false, false ), idx + 1)
            }
            3 -> {
                dfs(watch(board, point.first, point.second, true, false, true, false ), idx + 1)
                dfs(watch(board, point.first, point.second, true, false, false, true ), idx + 1)
                dfs(watch(board, point.first, point.second,  false, true,true, false ), idx + 1)
                dfs(watch(board, point.first, point.second, false, true, false,true ), idx + 1)
            }
            else -> {
                dfs(watch(board, point.first, point.second, true, true, true, false ), idx + 1)
                dfs(watch(board, point.first, point.second, true, true, false, true ), idx + 1)
                dfs(watch(board, point.first, point.second, true, false, true, true ), idx + 1)
                dfs(watch(board, point.first, point.second, false, true, true, true ), idx + 1)
            }
        }
    }
    dfs(board, 0)
    println(ans)
}