import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val num = readLine().toInt()
    val answer = Array(2 * num - 1){
        CharArray(4 * num - 3){' '}
    }

    var num1 = 1
    val num2 = num - 1
    var num3 = 2 * num - 4
    val num4 = (num - 1) * 2

    val a = "*".repeat(num)
    val b = " ".repeat((num - 1) * 2 - 1)
    val c = (a + b + a).toCharArray()
    answer[0] = c
    answer[answer.lastIndex] = c

    for(i in 1 until num){
        var idx = num1
        answer[i][idx] = '*'
        answer[num4 - i][idx] = '*'
        idx += num2
        answer[i][idx] = '*'
        answer[num4 - i][idx] = '*'
        idx += num3
        answer[i][idx] = '*'
        answer[num4 - i][idx] = '*'
        idx += num2
        answer[i][idx] = '*'
        answer[num4 - i][idx] = '*'
        num1++
        num3 -= 2
    }

    val stars = StringBuilder()
    for(i in answer){
        stars.append(i.joinToString("").trimEnd()).append('\n')
    }
    print(stars)
}