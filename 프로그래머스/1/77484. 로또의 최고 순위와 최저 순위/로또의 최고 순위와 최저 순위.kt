class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val readdableLotto = lottos.filter{ it != 0 }
        val cntOfUnknown = 6 - readdableLotto.size
        var cntOfWin = 0
        
        for(num in readdableLotto){
            if(win_nums.indexOf(num) != -1)
                cntOfWin++
        }
        val rank = intArrayOf(6, 6, 5, 4, 3, 2, 1)
        return intArrayOf( rank[cntOfWin + cntOfUnknown], rank[cntOfWin])
    }
}