fun main() {
    val n = readln()
    val (a, b) = readln().split(" ").map{it.toInt()}
    val l = readln().split(" ").map{it.toInt()}.sortedDescending()
    var tmp = a * b
    for((i, n) in l.withIndex()) {
        tmp -= n 
        if(tmp <= 0){
            println(i + 1)
            return
        }
    }
    println("STRESS")
    
}