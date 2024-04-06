import java.util.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {

    val str1 = '0' + readLine()
    val str2 = '0' + readLine()

    val common = Array(str2.length + 1) { IntArray(str1.length + 1) { 0 } }
    var max = 0

    for(i in 1 until str2.length){
        for(j in 1 until str1.length){
            if(str2[i] == str1[j]){
                common[i][j] = common[i - 1][j - 1] + 1
                max = Math.max(max, common[i][j])
            }
        }
    }
    print(max)
}