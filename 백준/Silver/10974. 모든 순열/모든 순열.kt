import java.util.*
import java.io.*

val answer = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val num = readLine().toInt()
    val nums = IntArray(num){
        it + 1
    }
    func(num, BooleanArray(num), intArrayOf())
    print(answer)
}

fun func(num: Int, visited: BooleanArray, comb: IntArray){
    if(comb.size == visited.size)
        answer.append(comb.joinToString(" ")).append('\n')

    for(i in 0  until num){
        if(visited[i])
            continue
        visited[i] = true
        func(num, visited, comb + (i + 1))
        visited[i] = false
    }
}