import java.util.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`)))  {

    val num = readLine().toInt()
    val answer = StringBuilder()
    val input = readLine()
    var pattern = ""

    for(ch in input){
        pattern += when(ch){
            '*' -> ".*"
            else -> ch.toString()
        }
    }
    val regex = Regex(pattern)

    for(i in 0 until num){
        val file = readLine()
        if(file.matches(regex))
            answer.append("DA").append('\n')
        else
            answer.append("NE").append('\n')
    }
    println(answer)



}
