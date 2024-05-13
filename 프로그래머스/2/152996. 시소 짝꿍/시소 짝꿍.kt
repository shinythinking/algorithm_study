class Solution {
    fun solution(weights: IntArray): Long {
        var answer = 0L
        val numbers = IntArray(1001)
        for(weight in weights)
            numbers[weight]++
        
        for(weight in 100..750){
            if(numbers[weight] == 0)
                continue
            val number = numbers[weight].toLong()
            answer += (number * (numbers[weight] - 1)) / 2 
            
            if(weight % 3 == 0)
                answer += number * numbers[weight / 3 * 4]
            
            if(weight <= 666){
                if(weight <= 500){
                    answer += number * numbers[weight * 2]
                }
                
                if(weight % 2 == 0){
                    answer += number * numbers[weight / 2 * 3]
                }
            }
        }
        
        for(weight in 751..1000){
            if(numbers[weight] > 1)
                answer += (numbers[weight].toLong() * (numbers[weight] - 1)) / 2
        }
        return answer
    }
}