import java.util.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {

    var testCase = readLine().toInt()
    var answer = StringBuilder()
    while(testCase --> 0){
        val num = readLine().toInt()
        val book = Array<String>(num) { "" }
        for(i in book.indices)
            book[i] = readLine()

        book.sort()
        var word = "YES"
        for(i in 0 until num - 1){
            if(book[i].length <= book[i + 1].length){
                if(book[i] == book[i + 1].substring(0 until book[i].length)) {
                    word = "NO"
                    break
                }
            }
        }
        answer.append(word).append('\n')
    }
    print(answer)
}