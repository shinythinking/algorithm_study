fun main () {
    val reader = System.`in`.bufferedReader()
    val nums = reader.readLine().split(" ").map{ it.toInt() }
    var cur = 0
    while(cur < nums.lastIndex) {
        if(nums[cur] > nums[cur + 1]){
            println("Bad")
            return
        }
        cur++
    }
    println("Good")
}