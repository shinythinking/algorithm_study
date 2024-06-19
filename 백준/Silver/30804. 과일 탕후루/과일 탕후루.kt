import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val num = readLine().toInt()
    val fruits = readLine().split(' ').map{ it.toInt() }
    var cnt = 1
    var answer = 0

    val setOfFruits = mutableSetOf<Int>()

    var left = 0
    var right = 1
    var diffTypeIdx = 0
    setOfFruits.add(fruits[left])

    while(right < fruits.size){
        //left .. right
        setOfFruits.add(fruits[right])

        if(setOfFruits.size <= 2){
            if(fruits[right] != fruits[right - 1]){
                diffTypeIdx = right - 1
            }
        } else {
            answer = Math.max(answer, cnt)
            setOfFruits.remove(fruits[diffTypeIdx])
            left = diffTypeIdx + 1
            diffTypeIdx = right - 1
            cnt = right - left
        }

        cnt++
        right ++
    }
    answer = Math.max(answer, cnt)
    print(answer)
}