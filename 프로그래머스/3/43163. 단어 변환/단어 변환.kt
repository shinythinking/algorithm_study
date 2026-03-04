class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0
        val queue = ArrayDeque<Pair<String, Int>>()
        val s = mutableSetOf<String>()
        queue.addLast(begin to 1)
        s.add(begin)
        
        fun canChange(from: String, to:String): Boolean {
            var cnt = 0
            for(i in 0..from.lastIndex){
                if(from[i] != to[i]){
                    cnt++
                    if(cnt >=2) return false
                }
            }
            if(cnt == 1) return true
            else return false
        }
        
        while(queue.isNotEmpty()) {
            val offered = queue.removeFirst()
            for(word in words) {
                if(s.contains(word)) continue
                if(!canChange(offered.first, word)) continue
                if(word == target) {
                    return offered.second
                }
                s.add(word)
                queue.addLast(word to offered.second + 1)
                
            }
        }
        
        return 0
    }
}