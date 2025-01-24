fun main() {
    val reader = System.`in`.bufferedReader()
    val gate = reader.readLine().toInt()
    val numOfPlane = reader.readLine().toInt()
    val planes = IntArray(numOfPlane) {
        reader.readLine().toInt()
    }
    var answer = 0
    val occupiedGates = BooleanArray(gate + 1)
    var isFull = true
    val dockingStationPerPlace = mutableMapOf<Int, Int>()

    for(plane in planes) {
        var endIdx = plane + 1
        if(dockingStationPerPlace.containsKey(plane)) {
            endIdx = dockingStationPerPlace[plane]!!
        }
        for(i in endIdx - 1 downTo 1 ){
            if(!occupiedGates[i]) {
                occupiedGates[i] = true
                answer++
                isFull = false
                dockingStationPerPlace[plane] = i
                break
            }
        }
        if(isFull) {
            println(answer)
            return
        }
        isFull = true
    }

    println(answer)
}