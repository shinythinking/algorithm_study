class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        
        var answer = IntArray(photo.size)
        val map = mutableMapOf<String, Int>()
        for(i in name.indices){
            map[name[i]] = yearning[i]
        }
        
        var idx = 0
        for(arr in photo){
            var score = 0
            for(str in arr){
                score += map.getOrDefault(str, 0)
            }
            answer[idx++] = score
        }
        return answer
    }
}