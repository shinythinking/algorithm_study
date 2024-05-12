import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var testCase = readLine().toInt()
    val answer = StringBuilder()
    while(testCase --> 0){
        val numbers = mutableSetOf<Int>()
        val lenA = readLine().toInt()
        readLine().split(' ').map { numbers.add(it.toInt()) }
        val lenB = readLine().toInt()
        val input = readLine().split(' ').map(String::toInt)

        for(d in input){

                if(d in numbers)
                    answer.append(1).append('\n')
                else
                    answer.append(0).append('\n')


        }
    }
    print(answer)
}