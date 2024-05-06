import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val(sequence, reach) = readLine()!!.split(' ').map { it.toInt() }
    val burgerAndPerson = readLine().toCharArray()

    var lastEaten = -1
    var answer = 0
    for((i, ch) in burgerAndPerson.withIndex()) {
        if(ch == 'P'){
            var from = i -reach
            var to = i + reach
            if(i - reach <= lastEaten)
                from = lastEaten + 1

            if(to >= burgerAndPerson.size)
                to = burgerAndPerson.lastIndex

            for(j in from..to){
                if(burgerAndPerson[j] == 'H') {
                    burgerAndPerson[j] = 'E'
                    lastEaten = j
                    answer++
                    break
                }
            }
        }
    }
    println(answer)
}