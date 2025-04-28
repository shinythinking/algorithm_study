fun main () {
    val reader = System.`in`.bufferedReader()
    var maxIdx = 0
    var max = Int.MIN_VALUE
    repeat(5){ i ->
        val num = reader.readLine().split(" ").map{it.toInt()}.sum()
        if(max < num) {
            maxIdx = i
            max = num
        }
    }
    println("${maxIdx + 1} $max")
}