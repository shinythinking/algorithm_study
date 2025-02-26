fun main() {
    val reader = System.`in`.bufferedReader()
    val (limit, num) = reader.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, MutableList<String>>()
    var freqPrice = 100_001
    repeat(num) {
        val (name, p) = reader.readLine().split(" ")
        val price = p.toInt()
        if(map.containsKey(price)) {
            map[price]?.add(name)
        } else {
            map[price] = mutableListOf(name)
        }
    }
    for((key, value) in map) {
        if(value.size == (map[freqPrice]?.size ?: 100000)) {
            if(freqPrice > key) {
                freqPrice = key
            }
        }
        else if (value.size < (map[freqPrice]?.size ?: 100000)) {
            freqPrice = key
        }
    }
    println("${map[freqPrice]?.first()} ${freqPrice}")

}