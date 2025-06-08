fun main(){
val reader = System.`in`.bufferedReader()
    val (num, size) = reader.readLine().split(" ").map{it.toInt()}
    val tmp = num * size
    val nums = reader
        .readLine()
        .split(" ")
        .map{ it.toInt() - tmp }
        .joinToString(" ")
    println(nums)
}