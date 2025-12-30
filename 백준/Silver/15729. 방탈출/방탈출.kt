
fun main() {
    val n = readln().toInt()
    val target = (readln().split(" ").map{it == "1"} + listOf(true, true)).toMutableList()
    var idx = 0
    var cnt = 0
    while(idx < n){
        if(target[idx]){
            cnt++
            target[idx] = false
            target[idx + 1] = !target[idx + 1]
            target[idx + 2] = !target[idx + 2]
        }
        idx++
    }
    println(cnt)
}