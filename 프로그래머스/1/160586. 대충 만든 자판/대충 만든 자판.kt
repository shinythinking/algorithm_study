import java.util.*

class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val mappingkey = mutableMapOf<Char, Int>()
        for(str in keymap){
            for((i, ch) in str.withIndex()){
                mappingkey[ch] = Math.min(mappingkey.getOrDefault(ch, 1000), i)
            }
        }
        
        for(target in targets){
            var sum = 0
            for(ch in target){
                if(mappingkey.contains(ch)){
                    sum += mappingkey[ch]!! + 1
                }else{
                    sum = -1
                    break
                }
            }
            answer += sum
        }
        return answer
    }
}