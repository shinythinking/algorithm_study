import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (sizeA, sizeB) = readLine()!!.split(' ').map { it.toInt() }
    val pq = PriorityQueue<Int>(sizeA + sizeB)
    val A = readLine().split(' ').map { it.toInt() }
    val B = readLine().split(' ').map { it.toInt() }
    for(i in 0 until sizeA) {
        pq.offer(A[i])
    }
    for(i in 0 until sizeB) {
        pq.offer(B[i])
    }

    val answer = StringBuilder()
    for(i in 0 until pq.size)
        answer.append(pq.poll()).append(' ')
    print(answer)
}