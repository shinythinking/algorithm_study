class Solution {
    fun solution(n: Long): Long {
        var answer: Long = 0
    
        val inputStr = n.toString()
        var inputArr = IntArray(inputStr.length)
        for(i in inputStr.indices){
            inputArr[i] = inputStr[i] - '0'
        }
        inputArr.sortDescending()
        return inputArr.joinToString("").toLong()

    }
}