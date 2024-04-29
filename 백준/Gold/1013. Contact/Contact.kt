import java.util.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`)))  {


    val answer = StringBuilder()
    val num = readLine().toInt()
    val regex1 = "(100+1+|01)+".toRegex()
    
    for(i in 1..num) {
        val input = readLine()
        if(input.matches(regex1)) 
            answer.append("YES").append('\n')
        else
            answer.append("NO").append('\n')
    }
    println(answer)

}