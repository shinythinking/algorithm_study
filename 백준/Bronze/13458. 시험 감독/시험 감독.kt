fun main() {
    val reader = System.`in`.bufferedReader()
    val input = reader.readLine().toLong()
    val stage = reader.readLine().split(" ").map { it.toInt() }
    val (main, sub) = reader.readLine().split(" ").map { it.toInt() }
    var answer = input
    for(s in stage) {
        val temp = s - main
        if(temp > 0) {
            answer +=  temp/sub + if(temp % sub == 0) 0  else 1
        }
    }
    println(answer)
}