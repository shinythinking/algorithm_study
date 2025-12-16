import java.util.*
fun main(){
      val n = readln()
    val arr = readln().split(" ").map { it.toInt() }
    val tail = mutableListOf<Int>()
    for (d in arr) {
        val invIdx = Collections.binarySearch(tail, d)
        val idx = invIdx.inv()
        if(idx < 0) continue
        if (tail.size > idx) {
            tail[idx] = d
        } else {
            tail.add(d)
        }
    }
    println(tail.size)
}