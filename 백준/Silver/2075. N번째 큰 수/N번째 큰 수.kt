fun main() = with(System.`in`.bufferedReader()){
    val num = readLine().toInt()
    val nums = sortedSetOf<Int>()
    for(i in 0 until num){
        nums.addAll(readLine().split(' ').map{ it.toInt() })
    }
    print(nums.toList()[num * (num - 1)])
}