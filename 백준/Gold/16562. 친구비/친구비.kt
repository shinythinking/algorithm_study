fun main() {
    val br = System.`in`.bufferedReader()
    val (num, rel, money) = br.readLine().split(" ").map{it.toInt()}
    val cost = listOf(0) + br.readLine().split(" ").map{it.toInt()}
    val parent = IntArray (num + 1) { it }
    fun find(x: Int): Int {
        if(x == parent[x]) return x
        parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(x: Int, y: Int) {
        val pX = find(x) 
        val pY = find(y) 
        if(cost[pX] > cost[pY]) {
            parent[pX] = pY
        } else {
            parent[pY] = pX
        }
    }
    repeat(rel) {
        val (a, b) = br.readLine().split(" ").map{it.toInt()}
        union(a, b)
    }
    for(i in 1 .. num) find(i)
    val ss = parent.toMutableSet()
    ss.remove(0)
    var ans = 0
    for(c in ss) {
        ans += cost[c]
    }
    
    if(ans > money) println("Oh no")
    else println(ans)
    
}