fun main() {
    val (n,m) = readln().split(" ").map{it.toInt()}
    val c = readln().toInt()
    val n0 = readln().toInt()
    if(n*n0 + m <= c*n0) {
        if(n*100 + m <= c*100)
            println(1)
        else 
            println(0)
    }else {
        println(0)
    }
}