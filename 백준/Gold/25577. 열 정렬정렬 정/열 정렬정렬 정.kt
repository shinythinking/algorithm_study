fun main() {
    val n = readln().toInt()
    val input = readln().split(" ").map { it.toInt() }
    val visited = BooleanArray(n + 1)
    var ans = 0
    val sorted = input.sorted()
    val indexMap = mutableMapOf<Int, Int>()
    for(i in 0 until n){
        indexMap[sorted[i]] = i
    }
    val level = IntArray(n){
        indexMap[input[it]]!!
    }
    for(i in 0 until n) {
        if(visited[i]) continue
        visited[i] = true
        var next = level[i]
        while(next != i){
            visited[next] = true
            ans++
            next = level[next]
        }
    }
    println(ans)
}