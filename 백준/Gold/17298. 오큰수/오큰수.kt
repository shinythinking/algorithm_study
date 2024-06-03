import java.util.*
import java.io.*

data class Element(
    val index: Int,
    val num: Int
)
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {

    val num = readLine().toInt()

    var answer = IntArray(num){ -1 }
    val nums = readLine().split(' ').map { it.toInt() }

    val stack = ArrayDeque<Element>()

    for((i, num) in nums.withIndex()){

        while(true){
            if(num <= (stack.peek()?.num?: break))
                break

            answer[stack.pop().index] = num
        }

        stack.push(Element(i, num))
    }

    print(answer.joinToString(" "))
}