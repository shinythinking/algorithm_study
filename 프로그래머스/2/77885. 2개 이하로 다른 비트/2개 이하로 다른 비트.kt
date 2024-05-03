class Solution {
    fun solution(numbers: LongArray): LongArray {
        var answer = longArrayOf()
        
        for(number in numbers){
            var needMore = true
            var binary = number.toString(2).toCharArray()
            for(i in binary.lastIndex downTo 0){
                if(binary[i] == '0'){
                    binary[i] = '1'
                    if(i < binary.lastIndex)
                        binary[i + 1] = '0'
                    needMore = false
                    break
                }
            }
            
            if(needMore){
                val newB = charArrayOf('1')
                binary[0] = '0'
                binary = newB + binary
            }
            answer += binary.joinToString("").toLong(2)
        }
        
        return answer
    }
}