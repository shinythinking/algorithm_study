import java.util.*
fun main() {
    val (w, h) = readln().split(" ").map { it.toInt() }
    val item = readln().toInt()
    val originBoard = Array(h) {
        IntArray(w) { -1 }
    }
    val playBoard = Array(h) {
        IntArray(w) { 0 }
    }
    val visited = Array(h) { BooleanArray(w) { false } }
    val list = mutableListOf<Pair<Int,Int>>()
    val dRow = intArrayOf(1, -1, 0, 0)
    val dCol = intArrayOf(0, 0, 1, -1)
    val redQueue = LinkedList<Pair<Pair<Int, Int>, Int>>()

    repeat(item) {
        val (type, iW, iH) = readln().split(" ")
        when (type) {
            "redstone_block" -> {
                val height = iH.toInt()
                val width = iW.toInt()
                originBoard[iH.toInt()][iW.toInt()] = 1
                redQueue.addLast(Pair(Pair(height,width), 16))
                playBoard[height][width] = 16
            }
            "redstone_dust" -> originBoard[iH.toInt()][iW.toInt()] = 2
            "redstone_lamp" -> {
                val height = iH.toInt()
                val width = iW.toInt()
                originBoard[iH.toInt()][iW.toInt()] = 3
                list.add(Pair(height, width))
            }
        }
    }

    while (redQueue.isNotEmpty()) {
        val (p, cost) = redQueue.removeFirst()
        val newCost = cost -1
        for(i in 0..3) {
            val newR = p.first + dRow[i]
            val newC = p.second + dCol[i]

            if(newR < 0 || newC < 0 || newR >= h|| newC >=w) continue
            if(originBoard[newR][newC] == 0 || originBoard[newR][newC] == 1) continue
            if(playBoard[newR][newC] >= newCost) continue
            playBoard[newR][newC] = newCost
            if(originBoard[newR][newC] == 2) redQueue.addLast(Pair(Pair(newR, newC), newCost))
        }
    }
    for((r,c) in list){
        if(playBoard[r][c] <=0) {
            println("failed")
            return
        }
    }
    println("success")
}