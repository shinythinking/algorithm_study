fun main() {
    val num = readln().toInt()
    var answer = 1L
    for (i in 2..num) {
        val tmp = i.toString().trimEnd('0').toLong()
        answer = (answer * tmp).toString().trimEnd('0').takeLast(12).toLong()
    }

    println(answer.toString().trimEnd('0').takeLast(5))
}