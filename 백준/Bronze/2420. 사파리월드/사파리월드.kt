fun main() {
    val reader = System.`in`.bufferedReader()
    val (v1, v2) = reader.readLine().split(" ").map{it.toLong()}
    println(Math.abs(v1 - v2))
}