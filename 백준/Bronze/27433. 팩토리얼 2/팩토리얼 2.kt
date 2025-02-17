fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toLong()
    println(recur(num))
    
}
fun recur(next: Long): Long {
    if(next > 1 ) {return next * recur(next - 1L)}
    else return 1
}