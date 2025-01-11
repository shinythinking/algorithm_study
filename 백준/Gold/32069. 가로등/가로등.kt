fun main() {
    val reader = System.`in`.bufferedReader()
    var (numOfRoads, numOfLights, numOfAnswer) = reader.readLine().split(" ").map { it.toInt() }
    val answerNum = numOfAnswer
    val roads = reader.readLine().split(" ").map { it.toInt() }
    val setOfCountedRoad = mutableSetOf<Int>()
    val answer = mutableListOf<Int>()
    var inc = 0
    while(numOfAnswer > 0){

        for(road in roads){
            if(!setOfCountedRoad.contains(road + inc) && road + inc <= numOfRoads){
                answer.add(inc)
                setOfCountedRoad.add(road + inc)
                numOfAnswer--
            }
            if(!setOfCountedRoad.contains(road - inc) && road - inc >= 0){
                answer.add(inc)
                setOfCountedRoad.add(road - inc)
                numOfAnswer--
            }
        }

        inc++
    }
    println(answer.take(answerNum).joinToString("\n"))
}