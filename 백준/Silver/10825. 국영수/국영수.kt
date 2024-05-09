import java.util.*
import java.io.*


data class Student(
    val name: String,
    val korean: Int,
    val english: Int,
    val math: Int
)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val answer = StringBuilder()
    val num = readLine()!!.toInt()
    val pq = PriorityQueue<Student>(
        compareByDescending<Student> { it.korean }
            .thenBy { it.english }
            .thenByDescending { it.math }
            .thenBy{ it.name }
    )
    for(i in 1..num) {
        val input = readLine()!!.split(" ")
        pq.offer(Student(input[0], input[1].toInt(), input[2].toInt(), input[3].toInt()))
    }

    for (i in 1..num) {
        answer.append(pq.poll().name).append('\n')
    }

    println(answer)
}