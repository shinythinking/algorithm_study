fun main() {
    val reader = System.`in`.bufferedReader()
    val (a,b,c) = reader.readLine().split(" ").map{it.toInt()}
    if(a*b <= c) println("0") else println("${a*b-c}")
}