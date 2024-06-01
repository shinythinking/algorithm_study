import java.util.*
import java.io.*

data class Line(
    val from: Int,
    val to: Int
)

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var answer = 0
    val num = readLine().toInt()
    val lines = PriorityQueue<Line>(compareBy( { it.from }, { it.to } ))

    for(i in 1..num) {
        val line = readLine().split(' ').map{ it.toInt() }
        lines.offer(Line(line[0], line[1]))
    }


    var standard = lines.poll()
    while(lines.isNotEmpty()) {
        val nextL = lines.poll()

        if(nextL.from in standard.from..standard.to) {
            standard = Line(standard.from, Math.max(nextL.to, standard.to))
        } else {
            answer += standard.to - standard.from
            standard = nextL
        }
    }
    answer += standard.to - standard.from

    print(answer)
}