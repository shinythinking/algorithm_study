fun main() {
    val num = readln().toInt()
    if(num == 1){
        println("1\n1 1")
    } else {
        val answer = buildString{
            appendLine((num - 1) * 2)
            for (i in 2..num - 1){
                appendLine("1 $i")
                appendLine("$num $i")
            }
            appendLine("1 1")
            appendLine("1 $num")
        }
        println(answer)
    }  
}