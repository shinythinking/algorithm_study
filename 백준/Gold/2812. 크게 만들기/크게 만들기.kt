import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val (n, remove) = reader.readLine()!!.split(' ').map { it.toInt() }
    val input = reader.readLine().map { it - '0' }
    val stack = ArrayDeque<Int>()

    var count = 0
    var answer = ""

    for (i in input.indices) {
        val cur = input[i]

        while((stack.peekLast() ?: Int.MAX_VALUE) < cur){
            stack.removeLast()
            count++

            if (count == remove) {
                answer = buildString {
                    append(cur)
                    while (stack.isNotEmpty()) {
                        append(stack.removeLast())
                    }
                    reverse()
                    input.slice(i + 1..input.lastIndex).map{
                        append(it)
                    }
                }
                break
            }
        }

        stack.addLast(cur)
    }
    if(count < remove) {
        repeat(remove - count) {
            stack.removeLast()
        }
        answer = stack.joinToString("")
    }
    println(answer)
}