import java.util.*
import java.io.*
/*

fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    val bridge = LinkedList<Int>()
    var currentWeight = 0
    var currentTime = 0
    var currentTruck = 0
    var firstIdx = 0
    for(truck in truck_weights){
        currentTime++

        while(currentTruck >= bridge_length){
            currentTruck--
            currentTime = bridge.poll()
            currentWeight -= truck_weights[firstIdx++]
        }
        while(currentWeight + truck > weight){
            currentTruck--
            currentTime = Math.max(currentTime, bridge.poll())
            currentWeight -= truck_weights[firstIdx++]
        }
        bridge.offer(currentTime + bridge_length)
        currentTruck++
        currentWeight += truck
    }

    return bridge.last()
}
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var answer = 0L
    val num = readLine().toInt()
    val intArr = IntArray(num)
    for(i in 0 until num)
        intArr[i] = readLine().toInt()
    intArr.sort()
    for((i, d) in intArr.withIndex())
        answer += Math.abs(d - (i + 1))
    print(answer)


    /*
        val powerTwo = ArrayList<Int>()
        var twoPower = 1
        while(twoPower <= N) {
            powerTwo.add(twoPower)
            twoPower *= 2
        }
        while(K > 1 && N > 0){
            K--
            N -= powerTwo.removeLast()
        }
        if(N <= 0){
            print(0)
        }else{
            val lastOne = if(powerTwo.last() >= N) powerTwo[powerTwo.lastIndex] else powerTwo[powerTwo.lastIndex] * 2
            print(lastOne - N)
        }*/

/*
    //IntArray == int[]
    //primitive 타입의 배열로 매핑
    //사이즈만 넘겨줘도 괜찮다.
    //toIntArray() 의 반환값
    val intArray = IntArray(5)
    var intArrof = intArrayOf()
    intArrof += 8
    println(intArray.javaClass)

    //Array<Int> == Integer[]
    //초기화를 해서 넘겨줘야 함.
    //toTypedArray()의 반환값
    val array1 = arrayOf(1920,0)
    val ar2 = arrayOf<Int>()
    val ar3 = ar2 + 1
    val arrayArrof = Array<Int?>(8){ null }

    println(array1.javaClass)*/

}
