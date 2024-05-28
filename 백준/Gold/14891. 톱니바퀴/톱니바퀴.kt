import java.util.*
import java.io.*

data class LRIndex(
    var left: Int = 6,
    var right: Int = 2
)

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {

    val indexes = Array<LRIndex>(4){ LRIndex() }
    val chains = Array<String>(4){
        readLine()
    }

    var rotate = readLine().toInt()
    val isSame = BooleanArray(3)

    while(rotate --> 0){
        var(target, direction) = readLine().split(' ').map{it.toInt()}
        target -= 1
        val howRotate = IntArray(4) { 0 }
        howRotate[target] = direction
        for(i in 0..2){
            isSame[i] = chains[i][indexes[i].right] == chains[i + 1][indexes[i + 1].left]
        }
        var idxForL = target - 1
        var idxForR = target
        while(idxForL >= 0){
            if(!isSame[idxForL]){
                howRotate[idxForL] = -howRotate[idxForL + 1]
                idxForL--
            } else
                break
        }
        while(idxForR < 3){
            if(!isSame[idxForR]){
                howRotate[idxForR + 1] = -howRotate[idxForR]
                idxForR++
            }else
                break
        }
        for((i, index) in indexes.withIndex()){
            index.left -= howRotate[i] - 8
            index.right -= howRotate[i] - 8
            index.left %= 8
            index.right %= 8
        }
    }
    var biStr = ""
    for((i, index) in indexes.withIndex()){
        biStr += chains[i][(index.left + 2) % 8]
    }
    biStr = biStr.reversed()

    print(biStr.toInt(2))
}