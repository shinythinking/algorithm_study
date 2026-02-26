fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val k = br.readLine().toInt()
    var left = 1
    var right = k
    var answer = 0
    while(left <= right) {
        val mid = (left + right) / 2
        var cnt = 0
        for(i in 1..n) {
            cnt += Math.min(mid/i,n)
        }
        if(cnt >=k){
            answer = mid
            right = mid - 1
        } else {
            left = mid +1
        }
    }
    println(answer)
}