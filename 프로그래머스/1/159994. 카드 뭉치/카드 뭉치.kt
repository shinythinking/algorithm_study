class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var idx1 = 0
        var idx2 = 0
        var answer = "Yes"
        for(str in goal){
            if(idx1 < cards1.size && cards1[idx1] == str)
                idx1++
            else if(idx2 < cards2.size && cards2[idx2] == str)
                idx2++
            else{
                answer = "No"
                break
            }           
        }
        
        return answer
    }
}