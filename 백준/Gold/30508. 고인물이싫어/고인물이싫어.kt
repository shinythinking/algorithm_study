
fun main() {
    val br = System.`in`.bufferedReader()
    val dRow = intArrayOf(0, 0, 1, -1)
    val dCol = intArrayOf(1, -1, 0, 0)
    val (row, col) = br.readLine().split(" ").map { it.toInt() }
    val (sizeHeight, sizeWidth) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(row + 1) {
        IntArray(col + 1)
    }
    for(i in 1..row ){
        graph[i] = intArrayOf(0) + br.readLine().split(" ").map { it.toInt() }
    }
    val canMove = Array(row + 1) { IntArray(col + 1){0} }
    val queue = ArrayDeque<Pair<Int, Int>>()
    val drainNum = br.readLine().toInt()
    repeat(drainNum) {
        val (r, c) = br.readLine().split(" ").map { it.toInt() }
        queue.add(r to c)
        canMove[r][c] = 1
    }
    // canMove 만들기
    while (queue.isNotEmpty()) {
        val (r, c) = queue.removeFirst()
        val height = graph[r][c]

        for(i in 0..3) {
            val nextR = r + dRow[i]
            val nextC = c + dCol[i]

            if(nextR !in 1..row || nextC !in 1..col) continue
//            println("$nextR , $nextC ")
            if(canMove[nextR][nextC] == 1) continue
            if(graph[nextR][nextC] < height) continue
            queue.add(nextR to nextC)
            canMove[nextR][nextC] = 1

        }
    }

//    println(canMove.joinToString("\n"){
//        it.joinToString { if(it)"1" else "0" }
//    })

    var ans = 0

    val accSum = Array(row + 1) { IntArray(col + 1) { 0 } }
    val line = sizeHeight * sizeWidth
    for(i in 1..row){
        for(j in 1..col) {
            accSum[i][j] = accSum[i-1][j] + accSum[i][j-1] - accSum[i-1][j-1] + canMove[i][j]
        }
    }
    for(i in sizeHeight..row){
        for(j in sizeWidth..col){
            val tmp = accSum[i-sizeHeight][j-sizeWidth] - accSum[i-sizeHeight][j] - accSum[i][j-sizeWidth] + accSum[i][j]
            if(tmp == line) {
                ans++
            }
        }
    }
    println(ans)
}