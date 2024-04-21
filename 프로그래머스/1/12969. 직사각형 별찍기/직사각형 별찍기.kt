fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    var answer = StringBuilder()
    for(i in 1..b){
        answer.append("*".repeat(a)).append('\n')
    }
    println(answer)
}