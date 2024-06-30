fun main() = with(System.`in`.bufferedReader()){
    val(row, col) = readLine().split(' ').map{ it.toInt() }
    var sum = 0

    val bowl = readLine().split(' ').map{ it.toInt() }
    val maxHeight = IntArray(col)
    val water = IntArray(col)
    var max = 0

    for(i in bowl.indices){
        max = Math.max(max, bowl[i])
        maxHeight[i] = max
        water[i] = max
    }

    max = 0
    for(i in bowl.lastIndex downTo 0){
        max = Math.max(max, bowl[i])
        maxHeight[i] = max
        water[i] = Math.min(max, water[i])
    }

    for(i in bowl.indices){
        water[i] -= bowl[i]
    }
    print(water.sum())
}
