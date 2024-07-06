fun main() = with(System.`in`.bufferedReader()){
    val num = readLine().toInt()
    val arr = readLine().split(' ').map{ it.toInt() }
    var left = 0
    var right = arr.lastIndex
    var diff = Int.MAX_VALUE
    var diffL = 0
    var diffR = 0

    var sum = 0
    while(left < right){
        sum = arr[left] + arr[right]
        if(sum > 0){
            if(diff > sum){
                diff =  sum
                diffL = left
                diffR = right
            }
            right --
        } else if(sum < 0){
            if(diff > -sum){
                diff = -sum
                diffL = left
                diffR = right
            }
            left++
        } else {
            diffL = left
            diffR = right
            break
        }
    }

    print("${arr[diffL]} ${arr[diffR]}")
}