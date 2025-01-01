package shinythinking

fun main() {
    val testCase = readln().toInt()
    var currentVolume = 0
    var totalDistance = 0
    var currentPosition = 0
    val answer = IntArray(testCase)
    var idx = 0
    repeat(testCase) {
        val (volume, num) = readln().split(" ").map { it.toInt() }
        currentVolume = 0
        currentPosition = 0
        totalDistance = 0
        val spots = mutableListOf<Pair<Int, Int>>()
        repeat(num) {
            val (distance, dump) = readln().split(" ").map { it.toInt() }
            spots.add(Pair(distance, dump))
        }

        for (i in spots.indices) {
            totalDistance += spots[i].first - currentPosition
            currentPosition = spots[i].first

            if (currentVolume + spots[i].second <= volume) {
                currentVolume += spots[i].second
                if (currentVolume == volume) {
                    totalDistance += currentPosition
                    currentPosition = 0
                    currentVolume = 0
                }
            } else {
                totalDistance += currentPosition * 2
                currentVolume = spots[i].second
            }
        }
        totalDistance += currentPosition

        answer[idx++] = totalDistance
    }
    println(answer.joinToString("\n"))
}