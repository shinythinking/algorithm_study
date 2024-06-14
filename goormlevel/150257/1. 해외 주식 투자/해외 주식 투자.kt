import java.io.*
import java.util.*

data class Price(
	val idx: Int,
	val total: Int
)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
	var num = readLine().toInt()
	var index = 1
	val comp = compareByDescending<Price> { it.total }.thenBy { it.idx }
	
	val pq = PriorityQueue<Price>(comp)
	
	while(num --> 0){
		var (quantity, cost) = readLine().split(' ').map{it.toDouble()}
		val temp = (quantity * cost * 10).toInt()
		pq.offer(Price(index++, temp))
	}
	
	val answer = StringBuilder()
	while(pq.isNotEmpty())
		answer.append(pq.poll().idx).append(' ')
		
	print(answer)
	
}