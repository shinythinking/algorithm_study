fun main() {
    val reader = System.`in`.bufferedReader()
    var (numOfRoads, numOfLights, numOfAnswer) = reader.readLine().split(" ").map { it.toLong() }
    val answerNum = numOfAnswer
    val roads = reader.readLine().split(" ").map { it.toLong() }
    val setOfCountedRoad = mutableSetOf<Long>()
    val answer = mutableListOf<Int>()
    var inc = 0L
    while(numOfAnswer > 0){

        for(road in roads){
            if(!setOfCountedRoad.contains(road + inc) && road + inc <= numOfRoads){
                answer.add(inc.toInt())
                setOfCountedRoad.add(road + inc)
                numOfAnswer--
            }
            if(!setOfCountedRoad.contains(road - inc) && road - inc >= 0){
                answer.add(inc.toInt())
                setOfCountedRoad.add(road - inc)
                numOfAnswer--
            }
        }

        inc++
    }
    println(answer.take(answerNum.toInt()).joinToString("\n"))
}