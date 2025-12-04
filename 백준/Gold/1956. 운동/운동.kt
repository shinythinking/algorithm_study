fun main() {
    val (v, e) =readln().split(" ").map{it.toInt()}
    val graph = Array(v + 1) {
        IntArray(v + 1) { 1_000_000_000 }
    }

    repeat(e) {
        val (s,e,cost) = readln().split(" ").map{it.toInt()}
        graph[s][e] = cost
    }
    
    for(k in 1..v) {
        for(i in 1..v){
            for(j in 1..v) {
                graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j])
            }
        }
    }
    var  ans = 1_000_000_000
    for(i in 1..v){
        if (ans > graph[i][i]) ans = graph[i][i]
    }
    if(ans == 1_000_000_000) println("-1")
    else println(ans)

}