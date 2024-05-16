import java.util.*

class Solution {
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
}