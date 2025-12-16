fun main(){
        val n = readln()
    val arr = readln().split(" ").map { it.toInt() }
    val tail = mutableListOf<Int>()
    for(d in arr) {
        val index = tail.binarySearch(d)
        if(index >= 0) continue
        else {
            val idx = index.inv()
            if(idx == tail.size) {tail.add(d)}
            else tail[idx] = d
        }
    }
    println(tail.size)
}