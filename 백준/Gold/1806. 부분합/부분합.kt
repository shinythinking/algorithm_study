fun main() {
    val reader = System.`in`.bufferedReader()
    val (num, target) = reader.readLine().split(" ").map { it.toInt() }
    val nums = reader.readLine().split(" ").map { it.toInt() }
    var left = 0
    var right = 0
    var sum = 0
    var answer = Int.MAX_VALUE
    while (left <= right && right < num) {
        sum += nums[right]
        if (sum >= target) {
            while (sum >= target && left <= right) {
                answer = Math.min(answer, right - left + 1)
                sum -= nums[left]
                left++
            }
            break
        }
        right++
    }
    if (answer == 1) {
        println(answer)
        return
    }

    while (left <= right && right < num - 1) {
        while (sum >= target) {
            if (left == right) {
                println(1)
                return
            }
            answer = right - left + 1
            sum -= nums[left]
            left++
        }
        sum -= nums[left]
        left++
        right++
        sum += nums[right]
    }

    while (sum >= target) {
        if (left == right) {
            println(1)
            return
        }
        answer = right - left + 1
        sum -= nums[left]
        left++
    }

    println(if(answer == Int.MAX_VALUE) 0 else answer)
}