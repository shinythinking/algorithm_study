import java.util.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`)))  {

    val answer = StringBuilder()
    val num = readLine().toInt()
/*    val regex1 = "100+1+".toRegex()
    val regex2 = "(01)*".toRegex() */

    val regex1 = "10{2,}1".toRegex()
    val regex2 = "(01)*".toRegex()
    val regex3 = "1*(01)*".toRegex()
    for(i in 1..num) {
        val input = readLine().split(regex1)
        var flag = false
        for((idx, j) in input.withIndex()){
            if(idx == 0&&!j.matches(regex2)) {
                flag = true
                break
            } else {
                if(!j.matches(regex3)) {
                    flag = true
                    break
                }
            }
        }

        if(flag)
            answer.append("NO").append('\n')
        else
            answer.append("YES").append('\n')
    }
    println(answer)

}