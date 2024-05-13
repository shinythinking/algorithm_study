class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var left = sequence.lastIndex
        var right = sequence.lastIndex
        var sum = sequence[right]
        var size = -1
        while(left >= 0){
            if(sum > k){
                sum -= sequence[right]
                right--
            } else if(sum < k){
                left--
                sum += sequence[left]
            } else {
                size = right - left
                break
            }
        }
        sum = 0
        left = 0
        right = size
        for(i in left..right)
            sum += sequence[i]
        
        while(true){
            if(sum == k){
                return intArrayOf(left, right)
            }
            
            right++
            sum = sum + sequence[right] - sequence[left]
            left++
        }
    }
}