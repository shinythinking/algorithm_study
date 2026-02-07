fun main() {
    val n = readln().toInt()
    var pFrom = -1_000_000_001
    var pTo = -1_000_000_001
    var ans = 0
    repeat(n) {
        val (from, to) = readln().split(" ").map{it.toInt()}
        if(to > pTo) {
            if(from <= pTo) {
                pFrom = pTo
                pTo = to
            } else {
                pFrom = from
                pTo = to
            }
            ans += pTo - pFrom
        }
    }
    println(ans)
}