import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (book, weight) = readLine().split(' ').map(String::toInt)
    val negativeLibrary = LinkedList<Int>()
    val positiveLibrary = LinkedList<Int>()
    val input = readLine().split(' ').map(String::toInt).sorted()
    for(l in input) {
        if(l < 0) negativeLibrary.add(l)
        else if(l > 0) positiveLibrary.add(l)
    }

    var answer = 0
    var isPositiveBig = true

    //weight 내에서 절댓값이 큰 값은 어디에 있는가 찾기
    var index = 0
    while(true) {
        if(negativeLibrary.size <= 0 + index){
            break
        }
        if(positiveLibrary.lastIndex - index < 0){
            isPositiveBig = false
            break
        }
        val temp = negativeLibrary[0 + index] + positiveLibrary[positiveLibrary.lastIndex - index]
        if (temp > 0) {
            break
        } else if (temp < 0) {
            isPositiveBig = false
            break
        } else {
            if(index <= weight){
                index++
            } else{
                break
            }
        }
    }

    // 절댓값이 가장 큰 값은 한번만 더해준다.
    if (isPositiveBig) {
        answer += positiveLibrary.peekLast()
    } else {
        answer -= negativeLibrary.peekFirst()
    }   
    
    // 절댓값이 가장 큰 값을 방문하면서 방문할 작은 녀석들 제거
    repeat(weight){
        if (isPositiveBig) {
            positiveLibrary.pollLast()
        } else {
            negativeLibrary.pollFirst()
        }
    }        

    if(negativeLibrary.isNotEmpty()) {
        for(i in 0 .. negativeLibrary.lastIndex step(weight))
            answer -= negativeLibrary[i] * 2
    }
    if(positiveLibrary.isNotEmpty()) {
        for(i in positiveLibrary.lastIndex  downTo 0 step(weight))
            answer += positiveLibrary[i] * 2
    }
    print(answer)
}