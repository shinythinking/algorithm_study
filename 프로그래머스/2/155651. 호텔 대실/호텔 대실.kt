import java.util.*

data class BookTime(
    val start: Int,
    val end: Int
)

class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        var idx = 0
        val timeArray = Array<BookTime>(book_time.size){
            val startTime = book_time[idx][0].split(':').map{ it.toInt() }
            val endTime = book_time[idx++][1].split(':').map{ it.toInt() }
            BookTime(startTime[0] * 60 + startTime[1], endTime[0] * 60 + endTime[1] + 10)
        }
        val comp = compareBy<BookTime>(
            {it.start},
            {it.end}
        )
        timeArray.sortWith(comp)
        
        val endTimeForRoom = PriorityQueue<Int>()
        endTimeForRoom.offer(timeArray[0].end)
        
        for(i in 1..timeArray.lastIndex){
            if(timeArray[i].start >= (endTimeForRoom.peek() ?: break)){
                endTimeForRoom.poll()
                endTimeForRoom.offer(timeArray[i].end)
            } else {
                endTimeForRoom.offer(timeArray[i].end)
            }
        }
        
        return endTimeForRoom.size
    }
}