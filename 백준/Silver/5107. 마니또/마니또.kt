fun main() {
    var input = readln().toInt()
    var totalIdx = 1
    while (input != 0) {
        val nameMap = mutableMapOf<String, Int>()
        val pointing = IntArray(input)
        var idx = 0
        repeat(input) {
            val (from, to) = readln().split(" ")
            if (!nameMap.containsKey(from)) nameMap.put(from, idx++)
            if (!nameMap.containsKey(to)) nameMap.put(to, idx++)
            val fromIdx = nameMap[from]!!
            val toIdx = nameMap[to]!!
            pointing[fromIdx] = toIdx
        }
        val visited = BooleanArray(idx) { false }
        val cycles = mutableListOf<List<Int>>()
        for(i in 0 until idx) {
            if(visited[i]) continue
            visited[i] = true
            var cur = i
            val curList = mutableListOf<Int>(i)
            while(true) {
                val next = pointing[cur]
                if(visited[next]) break
                visited[next] = true
                curList.add(next)
                cur = next
            }
            cycles.add(curList)
        }
        println("$totalIdx ${cycles.size}")
        input = readln().toInt()
        totalIdx++
    }
}