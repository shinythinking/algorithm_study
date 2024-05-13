import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val numOfCrane = readLine()!!.toInt()
    val cranes = readLine()!!.split(" ").map { it.toInt() }.sorted()
    val processingNum = IntArray(numOfCrane)
    val numOfBox = readLine()!!.toInt()
    val boxes = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()

    if(cranes.last() < boxes.first()) {
        print(-1)
        return
    }
    for(box in boxes) {
        val leastIdx = findSmallIdx(cranes, box)
        processingNum[leastIdx]++

        for(i in leastIdx until processingNum.lastIndex) {
            if(processingNum[i] > processingNum[i + 1]) {
                processingNum[i]--
                processingNum[i + 1]++
            }
            else {
                break
            }
        }
    }
    print(processingNum[processingNum.lastIndex])
}
fun findSmallIdx(cranes: List<Int>, target: Int): Int{
    var left = 0
    var right = cranes.size
    while(left <= right){
        val mid = (left + right) / 2
        if(cranes[mid] >= target){
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return left

}