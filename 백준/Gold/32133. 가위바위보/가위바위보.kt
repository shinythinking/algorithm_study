import kotlin.collections.ArrayDeque

data class Node(
    val idx: Int,
    val liveList: List<Int>,
    val history: String
)

fun main() {
    val reader = System.`in`.bufferedReader()
    val (n, round, present) = reader.readLine().split(" ").map { it.toInt() }

    val queue = ArrayDeque<Node>()
    val fNode = Node(-1, (0 until n).toList(), "")
    queue.addLast(fNode)

    val players = Array(n) {
        reader.readLine().toList()
    }

    while (queue.isNotEmpty()) {
        val offered = queue.removeFirst()
        val currentRound = offered.idx + 1
        val livePlayers = offered.liveList
        if (currentRound == round) break

        val pList = mutableListOf<Int>()
        val rList = mutableListOf<Int>()
        val sList = mutableListOf<Int>()

        for (playerIdx in livePlayers) {
            when (players[playerIdx][currentRound]) {
                'P' -> pList.add(playerIdx)
                'R' -> rList.add(playerIdx)
                'S' -> sList.add(playerIdx)
            }
        }
        if(pList.size <= present && pList.isNotEmpty()) {
            println("${currentRound + 1}\n"+offered.history+"R")
            return
        }
        if(sList.size <= present&& sList.isNotEmpty()) {
            println("${currentRound + 1}\n"+offered.history+"P")
            return
        }
        if(rList.size <= present&& rList.isNotEmpty()) {
            println("${currentRound + 1}\n"+offered.history+"S")
            return
        }

        if(pList.isNotEmpty()) queue.addLast(Node(currentRound, pList, offered.history+"R"))
        if(rList.isNotEmpty()) queue.addLast(Node(currentRound, rList, offered.history+"S"))
        if(sList.isNotEmpty()) queue.addLast(Node(currentRound, sList, offered.history+"P"))
    }

    println(-1)
}