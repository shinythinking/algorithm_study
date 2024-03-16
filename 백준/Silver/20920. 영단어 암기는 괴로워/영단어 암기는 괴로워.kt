import java.io.*
import java.util.*
import kotlin.Comparator

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`)) ) {
    val wordsFreq = mutableMapOf<String, Int>()
    val answer = java.lang.StringBuilder()

    val input = readLine().split(" ").map { it.toInt() }

    for (i in 1 .. input[0]){
        val str = readLine()
        if(str.length < input[1])
            continue

        val cnt = wordsFreq.getOrDefault(str, 0) + 1
        wordsFreq[str] = cnt
    }

    val wordsList = mutableListOf<String>()
    wordsList.addAll(wordsFreq.keys)

    wordsList.sortWith(kotlin.Comparator{ o1, o2 ->
        if(wordsFreq[o1] != wordsFreq[o2])
            wordsFreq[o2]!! - wordsFreq[o1]!!
        else if(o1.length != o2.length)
            o2.length - o1.length
        else o1.compareTo(o2)
    })

    for(str in wordsList){
        answer.append(str).append('\n')
    }
    print(answer)
}