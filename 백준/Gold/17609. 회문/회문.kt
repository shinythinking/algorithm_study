import java.util.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {

   var num = readLine().toInt()
    val answer = StringBuilder()
    while(num --> 0) {
        val input = StringBuilder(readLine())
        var palin = 0
        for(i in 0 until input.length/2){
            if(input[i] != input[input.lastIndex - i]){
                val leftD = StringBuilder(input)
                val rightD = StringBuilder(input)
                leftD.deleteCharAt(i)
                rightD.deleteCharAt(input.lastIndex - i)
                if(leftD.toString() == leftD.reverse().toString() || rightD.toString() == rightD.reverse().toString()){
                    palin = 1
                } else {
                    palin = 2
                }
                break
            }
        }
        answer.append(palin).append('\n')
    }
    print(answer)
}