import java.util.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {

    val target = StringBuilder(readLine())
    val input = StringBuilder(readLine())

    while(input.length != target.length){
        when(input.last()) {
            'A' -> input.deleteCharAt(input.lastIndex)
            else -> {
                input.deleteCharAt(input.lastIndex)
                input.reverse()
            }
        }
    }

    if(input.toString() == target.toString()){
        print(1)
    } else {
        print(0)
    }
}