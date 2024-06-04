class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        val newNumbers = numbers.map{ if(it == 0) 11 else it }
        
        var left = 10
        var right = 12
        for(number in newNumbers){
            when(number){
                1, 4, 7 -> {
                    left = number
                    answer += "L"
                    continue
                }
                3, 6, 9 -> {
                    right = number
                    answer += "R"
                    continue
                }
                else -> {}
            }             
                
            var leftCnt = 0
            var rightCnt = 0
            
            if(left % 3 == 1){
                leftCnt ++
            }     
            leftCnt += Math.abs(number - (left + leftCnt)) / 3
              
            if(right % 3 == 0){
                rightCnt++
            }
            rightCnt += Math.abs(number - (right - rightCnt)) / 3
            println(number)
            println("$leftCnt, $rightCnt")
            
            answer += if(rightCnt < leftCnt){
                right = number
                "R"
            } else if(rightCnt > leftCnt){
                left = number
                "L"
            } else {
                if(hand[0] == 'r'){
                    right = number
                    "R"
                } else {
                    left = number
                    "L"
                }
            }
            
        }
        return answer
    }
}