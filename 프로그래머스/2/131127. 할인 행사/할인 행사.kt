import java.util.*

class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var itemMap = HashMap<String, Int>()
        var answer: Int = 0
        
        for((i, str) in want.withIndex())
            itemMap[str] = number[i]
        
        var currentMap = HashMap(itemMap)
        var startIndex = 0 
        var endIndex = 0
        while(endIndex <= discount.size && discount.size - startIndex >= 10){
            if(endIndex - startIndex == 10){
                answer ++
                currentMap[discount[startIndex]] = currentMap[discount[startIndex]]!! + 1
                startIndex++
                continue
            }
            
            val currentItem = discount[endIndex]
            if(currentMap.getOrDefault(currentItem, -1) == -1){
                endIndex++
                startIndex = endIndex
                currentMap = HashMap(itemMap.toMap())
            } else if (currentMap.getOrDefault(currentItem, -1) == 0){
                while(discount[startIndex] != currentItem){
                    
                    currentMap[discount[startIndex]] = currentMap.getOrDefault(discount[startIndex], -1) + 1
                    startIndex++
                }
                //currentMap[discount[startIndex]] = currentMap.getOrDefault(discount[startIndex], -1) + 1

                startIndex++
                
                endIndex++
            } else {
                currentMap[currentItem] = currentMap.getOrDefault(currentItem, -1) - 1
                endIndex++
            }
        }
        
        return answer
    }
}