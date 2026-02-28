import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.collections.ArrayDeque

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    
    val board = Array(n + 1) { mutableListOf<Int>() }
    
    repeat(m) {
        st = StringTokenizer(br.readLine())
        val to = st.nextToken().toInt()
        val from = st.nextToken().toInt()
        board[from].add(to)
    }
    
    val ansArr = IntArray(n + 1)
    var maxCount = 0
    
    for (i in 1..n) {
        var ans = 1
        val queue = ArrayDeque<Int>()
        val visited = BooleanArray(n + 1)
        
        queue.addLast(i)
        visited[i] = true 

        while (queue.isNotEmpty()) {
            val offered = queue.removeFirst()
            for (node in board[offered]) {
                if (visited[node]) continue
                visited[node] = true
                queue.addLast(node)
                ans++
            }
        }
        ansArr[i] = ans
        if (ans > maxCount) {
            maxCount = ans
        }
    }

    val sb = StringBuilder()
    for (i in 1..n) {
        if (ansArr[i] == maxCount) {
            sb.append(i).append(" ")
        }
    }
    println(sb.toString().trim())
}