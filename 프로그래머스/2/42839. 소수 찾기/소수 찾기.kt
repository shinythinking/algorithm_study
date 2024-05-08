import java.util.*

class Solution {
    val setOfNumbers = mutableSetOf<Int>()
    
    fun solution(numbers: String): Int {
        val len = numbers.length
        val size = "9".repeat(len).toInt()
        
        val isComposite = BooleanArray(size + 1)
        isComposite[0] = true
        isComposite[1] = true
        for(d in 2..Math.sqrt(size.toDouble()).toInt()){
            
            if(!isComposite[d]){
                var next = d * d
                
                while(next < isComposite.size){
                    isComposite[next] = true
                    next += d
                }
            }
            
        }
        
        makeNumbers(BooleanArray(len), numbers, "")
        
        var answer = 0
        for(d in setOfNumbers){
            if(!isComposite[d])
                answer++
        }
        return answer
    }
    
    
    fun makeNumbers(visited: BooleanArray, entireNumber: String, newNumber: String){
        setOfNumbers.add(newNumber.toIntOrNull() ?: 0)
        
        if(visited.size == newNumber.length){
            return
        }
        
        for((i, ch) in entireNumber.withIndex()){
            if(visited[i])
                continue
            visited[i] = true
            makeNumbers(visited, entireNumber, newNumber + ch)
            visited[i] = false
        }
        
    }
}







