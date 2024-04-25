class Solution {
    fun solution(food: IntArray): String {
        var halfAns = ""
        for(i in 1..food.lastIndex){
            halfAns += i.toString().repeat(food[i] / 2)
        }
        return "${halfAns}0${halfAns.reversed()}"
    }
}