import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){

    val str = readLine()
    var alphaArr = IntArray(26)
    for(ch in str){
        alphaArr[ch - 'a'] ++
    }

    for(i in alphaArr)
        print("$i ")
}