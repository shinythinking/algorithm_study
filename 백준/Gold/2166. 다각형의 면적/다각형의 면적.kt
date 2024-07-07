fun main() = with(System.`in`.bufferedReader()){
    val num = readLine().toInt()
    val points = Array(num){
        val input = readLine().split(' ').map{ it.toLong() }
        Pair(input[0], input[1])
    }

    var sum = 0L
    for(i in 0 until points.lastIndex){
        sum += points[i].first * points[i + 1].second
        sum -= points[i + 1].first * points[i]. second
    }

    sum += points[num - 1].first * points[0].second
    sum -= points[num - 1].second * points[0].first
    sum = Math.abs(sum)

    if(sum % 2 == 0L){
        print(sum / 2)
        print(".0")
    } else {
        print(sum / 2)
        print(".5")
    }
}