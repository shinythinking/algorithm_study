import java.util.*
import java.io.*

data class Lecture(
    val start: Int,
    val end: Int
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val num = readLine().toInt()

    val comp = compareBy<Lecture>({ it.start }, { it.end })
    val timeTable = Array<Lecture>(num) {
        val input = readLine().split(' ').map(String::toInt)
        Lecture(input[0], input[1])
    }

    timeTable.sortWith(comp)
    val endTimeOfRoom = PriorityQueue<Int>()

    endTimeOfRoom.offer(timeTable[0].end)

    for(i in 1..timeTable.lastIndex) {
        val lecture = timeTable[i]
        if(lecture.start >= endTimeOfRoom.peek()) {
            endTimeOfRoom.poll()
            endTimeOfRoom.offer(lecture.end)
        } else {
            endTimeOfRoom.offer(lecture.end)
        }
    }
    print(endTimeOfRoom.size)
}