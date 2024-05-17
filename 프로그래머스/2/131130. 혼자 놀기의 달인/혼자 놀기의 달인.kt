class Solution {
    fun solution(cards: IntArray): Int {
        var ans = intArrayOf(0)
        var answer: Int = 0
        var intArr = intArrayOf(0) + cards
        for(card in cards){
            if(intArr[card] == 0)
                continue
            var current = card
            var next = intArr[current]
            var cnt = -1
            while(current != 0){
                val tmp = current
                current = intArr[current]
                intArr[tmp] = 0
                cnt++
            }
            ans += cnt
            println(cnt)
        }
        val sorted = ans.sortedDescending()
        
        return sorted[0] * sorted[1]
    }
}