class Solution {
    fun solution(m: Int, n: Int, startX: Int, startY: Int, balls: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()
        
        for(ball in balls){
            var min = 100_000_000
            if(startX != ball[0]){
                min = Math.min(min, calcDistance(startX, startY, ball[0], - ball[1]))
                min = Math.min(min, calcDistance(startX, startY, ball[0], 2 * n - ball[1]))
                
                if(startY == ball[1]){
                    if(startX < ball[0])
                        min = Math.min(min, ((startX + ball[0]) * (startX + ball[0])))
                    else 
                        min = Math.min(min, ((2 * m - startX - ball[0]) * (2 * m - startX - ball[0])))
                }
            }
            
            if(startY != ball[1]){
                min = Math.min(min, calcDistance(startX, startY, 2 * m - ball[0], ball[1]))
                min = Math.min(min, calcDistance(startX, startY, - ball[0], ball[1]))
                
                if(startX == ball[0]){
                    if(startY > ball[1])
                        min = Math.min(min, ((2 * n - startY - ball[1]) * (2 * n - startY - ball[1])))
                    else
                        min = Math.min(min, ((startY + ball[1]) * (startY + ball[1])))
                }
            }
            
            answer += min
        }
        return answer
    }
    
    fun calcDistance(x1: Int, y1: Int, x2: Int, y2: Int): Int{
        val tempX = x1 - x2
        val tempY = y1 - y2
        return tempX * tempX + tempY * tempY
    }
    
}