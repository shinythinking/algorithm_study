
import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val (r, c) = reader.readLine().split(" ").map { it.toInt() }
    val board = Array(r) {
        reader.readLine().split(" ").map { it.toInt() }
    }
    val sumMap = Array(r) {
        IntArray(c)
    }
    sumMap[0][0] = board[0][0]
    for(i in 1 until r) {
        sumMap[i][0] = sumMap[i - 1][0] + board[i][0]
    }
    for(i in 1 until c) {
        sumMap[0][i] = sumMap[0][i - 1] + board[0][i]
    }
    for(i in 1 until r) {
        for(j in 1 until c) {
            sumMap[i][j] = Math.max(sumMap[i][j - 1], sumMap[i - 1][j]) + board[i][j]
        }
    }
//    val visited = Array(r) { BooleanArray(c) }
//    sumMap[0][0] = board[0][0]
//    val queue = LinkedList<Pair<Int, Int>>()
//    queue.offer(Pair(0, 0))
//    val dr = intArrayOf(0, 1)
//    val dc = intArrayOf(1, 0)
//
//    while (queue.isNotEmpty()) {
//        val (row, col) = queue.poll()
//        visited[row][col] = true
//        for (i in 0..1) {
//            val newR = row + dr[i]
//            val newC = col + dc[i]
//            if (newR !in 0 until r || newC !in 0 until c) continue
//            if(sumMap[newR][newC] >= sumMap[row][col] + board[newR][newC]) {
//                if(!visited[newR][newC])
//                    queue.offer(Pair(newR, newC))
//                continue
//            }
//            sumMap[newR][newC] = sumMap[row][col] + board[newR][newC]
//            queue.offer(Pair(newR, newC))
//            println("$newR $newC ")
//        }
//    }
    println(sumMap[r - 1][c - 1])
}