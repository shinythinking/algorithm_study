fun main() {
    val reader = System.`in`.bufferedReader()
    val input = reader.readLine().toInt()
    val bars = IntArray(input) {
        reader.readLine().toInt()
    }
    var max = Int.MIN_VALUE
    var ans = 0
    for(i in bars.lastIndex downTo 0) {
        if(bars[i] > max) {
            max = bars[i]
            ans ++
        }
    }
    println(ans)
}