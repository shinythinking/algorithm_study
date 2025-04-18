import java.util.*

data class Customer(
    val index: Int,
    val time: Int
)

fun main() {
    val reader = System.`in`.bufferedReader()
    val (max, time, passenger) = reader.readLine().split(" ").map { it.toInt() }
    var currentTime = 0
    var isLeft = true
    val leftQueue = mutableListOf<Customer>()
    val rightQueue = mutableListOf<Customer>()
    repeat(passenger) { i ->
        val input = reader.readLine().split(" ")
        if (input[1] == "left") leftQueue.add(Customer(i, input[0].toInt()))
        else rightQueue.add(Customer(i, input[0].toInt()))
    }
    leftQueue.reverse()
    rightQueue.reverse()
    val boat = mutableListOf<Int>()
    val answer = IntArray(passenger)

    while (leftQueue.isNotEmpty() || rightQueue.isNotEmpty() || boat.isNotEmpty()) {
        if (boat.isNotEmpty()) {
            boat.forEach { answer[it] = currentTime }
            boat.clear()
        }

        val nextLeftTime = leftQueue.lastOrNull()?.time ?: Int.MAX_VALUE
        val nextRightTime = rightQueue.lastOrNull()?.time ?: Int.MAX_VALUE

        if (boat.isEmpty() && currentTime < nextLeftTime && currentTime < nextRightTime) {
            if (nextLeftTime < nextRightTime) {
                currentTime = if(!isLeft) nextLeftTime + time else nextLeftTime

                isLeft = true
            } else if (nextRightTime < nextLeftTime) {
                currentTime = if(!isLeft) nextRightTime else nextRightTime + time
                isLeft = false
            } else {
                currentTime = nextLeftTime
            }
        }

        if (isLeft) {
            while (leftQueue.isNotEmpty() && boat.size < max && leftQueue.last().time <= currentTime) {
                boat.add(leftQueue.removeLast().index)
            }
        } else {
            while (rightQueue.isNotEmpty() && boat.size < max && rightQueue.last().time <= currentTime) {
                boat.add(rightQueue.removeLast().index)
            }
        }

        currentTime += time
        isLeft = !isLeft
    }
    println(answer.joinToString("\n"))
}