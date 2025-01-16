fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val feelings = reader.readLine().split(" ").map { it.toInt() }
    val flowerDays = BooleanArray(num) { false }
    val listOfFeelings = mutableListOf<Pair<Int, Int>>()

    var days = 0

    for (i in feelings.indices) {
        if (feelings[i] < 0) days++
        else if (days != 0) {
            listOfFeelings.add(Pair(i - days, days))
            days = 0
        }
    }
    if (days != 0) {
        listOfFeelings.add(Pair(num - days, days))
        days = 0
    }

    var longestDay = 0
    val longestDays = mutableListOf<Int>()
    for ((i, day) in listOfFeelings.withIndex()) {
        if (day.second > longestDay) {
            longestDay = day.second
            longestDays.clear()
            longestDays.add(day.first)
        } else if (day.second == longestDay) {
            longestDays.add(day.first)
        }
    }

    val answer = mutableListOf<Int>()
    for (i in longestDays) {
        for ((index, day) in listOfFeelings) {
            val step = if(index == i) 3 else 2
            for(j in index - (step * day) until index){
                try{ flowerDays[j] = true }
                catch (e: Exception){}
            }
        }
        answer.add(flowerDays.count { it == true })
        flowerDays.fill(false, 0)
    }
    println(answer.maxOrNull() ?: 0)
}