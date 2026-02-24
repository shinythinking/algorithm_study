fun main() {
    val br = System.`in`.bufferedReader()
    val (floor, current, target, up, down) = br.readLine().split(" ").map{it.toInt()}
    val queue = ArrayDeque<Pair<Int, Int>>()
    val rep = intArrayOf(up, -down)
    queue.addLast(current to 0)
    val visited = BooleanArray(floor + 1) { false }
    visited[current] = true
    
    if(current == target){
        println(0)
        return 
    }
    
    while(queue.isNotEmpty()) {
        val dequeue = queue.removeFirst()
        for(step in rep) {
            val next = dequeue.first + step
            if(next == target){
                println(dequeue.second + 1)
                return
            }
            if(next <= 0 || next > floor) continue
            if(visited[next]) continue
            visited[next] = true
            
            queue.addLast(next to dequeue.second + 1)
        }
    }
    println("use the stairs")
}