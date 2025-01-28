fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val isPrime = BooleanArray(num + 1) { true }

    isPrime[0] = false
    isPrime[1] = false

    if (num == 1) {
        println(0)
        return
    }

    for (i in 2..num) {
        if (isPrime[i]) {
            if (i <= num / i) {
                for (j in i * i..num step i) {
                    isPrime[j] = false
                }
                
            }
        }
    }
    val primeNums = isPrime.withIndex().filter { it.value }.map { it.index }

    var left = 0
    var right = 0
    var answer = 0
    var sum = primeNums[left]
    while (left <= right) {
        while (sum < num && right < primeNums.size - 1) {
            right++
            sum += primeNums[right]
        }
        if (sum == num) {
            answer++
        }
        sum -= primeNums[left]
        left++
    }
    println(answer)
}