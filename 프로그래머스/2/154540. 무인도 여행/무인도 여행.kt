import java.util.*
class Solution {
    data class Pos(val x: Int, val y: Int)
    lateinit var myMaps : Array<StringBuilder>
    
    fun solution(maps: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        myMaps = Array<StringBuilder>(maps.size){ StringBuilder("") }
        for(i in myMaps.indices){
            myMaps[i] = StringBuilder(maps[i])
        }

        for(i in myMaps.indices){
            for(j in myMaps[i].indices){
                if(myMaps[i][j] == 'X')
                    continue
                else {
                    answer += BFS(j, i)
                }
            }
        }
        
        if(answer.size == 0)
            answer += -1
        else
            answer.sort()
            
        return answer
    }
    
    fun BFS(x: Int, y: Int): Int{
        val queue = LinkedList<Pos>()
        val dx = intArrayOf(1, -1, 0, 0)
        val dy = intArrayOf(0, 0, 1, -1)
        var cnt = myMaps[y][x] - '0'
        val start = Pos(x, y)
        queue.offer(start)
        while(!queue.isEmpty()){
            var polled = queue.poll()
            myMaps[polled.y][polled.x] = 'X'
            for(i in dx.indices){
                val newX = polled.x + dx[i]
                val newY = polled.y + dy[i]
                if(newX < 0 || newY < 0 || newX >= myMaps[0].length || newY >= myMaps.size)
                    continue
                if(myMaps[newY][newX] == 'X')
                    continue
                cnt += myMaps[newY][newX] - '0'
                myMaps[newY][newX] = 'X'
                queue.offer(Pos(newX, newY))
            }
        }
        return cnt
    }
}