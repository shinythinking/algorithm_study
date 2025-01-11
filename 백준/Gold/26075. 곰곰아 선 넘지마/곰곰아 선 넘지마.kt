import kotlin.math.abs

fun main () {
    val reader = System.`in`.bufferedReader()
    var moveA = 0L
    var moveB = 0L

    val (numOf0, numOf1) = reader.readLine().split(" ").map { it.toInt() }
    val target = if(numOf1 > numOf0) '1' else '0'
    val listA = reader.readLine().mapIndexed{ idx, ch ->
        if(ch == target) idx else null
    }.filterNotNull()
    val listB = reader.readLine().mapIndexed{ idx, ch ->
        if(ch == target) idx else null
    }.filterNotNull()

    var remain = 0
    for(i in listA.indices){
        val dif = abs(listB[i] - listA[i])
        moveA += dif / 2
        moveB += dif / 2

        if(dif % 2 != 0) remain ++
    }
    while(remain != 0) {
        if(moveA > moveB) {
            moveB++
        } else {
            moveA++
        }
        remain--
    }

    println(moveA * moveA + moveB * moveB)
}