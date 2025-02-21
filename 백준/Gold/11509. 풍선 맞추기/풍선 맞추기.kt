fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val nums = reader.readLine().split(" ").map { it.toInt() }
    val arrows = mutableListOf<Int>()
    var idx = 0
    for(i in 0 until num) {
        val idxOfBalloon = arrows.indexOf(nums[i])
        if(idxOfBalloon == -1){
            arrows.add(nums[i] - 1)
        } else {
            arrows[idxOfBalloon] -= 1
        }
    }
    
    println(arrows.size)
}