import java.util.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val num = readLine().toInt()
    val towers = readLine().split(' ').map { it.toInt() }
    val stack = ArrayDeque<Int>()
    val answer = IntArray(num)
    var max = 0
    for((i, tower) in towers.withIndex()){
        if(tower > max){
            answer[i] = 0
            max = tower
            stack.clear()
            stack.push(i)
            continue
        }

        while(towers[stack.peek()] < tower)
            stack.pop()

        answer[i] = stack.peek() + 1
        stack.push(i)
    }
    print(answer.joinToString(" "))
}