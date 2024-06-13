import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	val num = readLine().toInt()
	val roomA = readLine().split(' ').map{it.toInt()}.sorted()
	val roomB = readLine().split(' ').map{it.toInt()}.sorted()
	
	//println(roomA.joinToString(" "))
	//println(roomB.joinToString(" "))
	
	val resA = getResult(roomA)
	val resB = getResult(roomB)
	println("$resA $resB")
	
	println(if(resA > resB) "good" else "bad")
}
fun getResult(room: List<Int>): Int{
	var leftIdx = 0
	var rightIdx = 0
	var right = room[0]
	var cnt = 0
	
	for((i, rat) in room.withIndex()){
		if(rat <= right)
			cnt++
		else {
			rightIdx = i
			break
		}
	}
	
	var max = cnt
	var maxV = right - 2 
	
	for(left in room[0] - 3 .. room.last()){
		right ++
		
		while(room[leftIdx] < left){
			cnt--
			leftIdx ++
		}
		while(rightIdx < room.size && room[rightIdx] <= right){
			rightIdx ++
			cnt++
		}
		
		
		//println("$left .. $right -> $cnt")
		if(max < cnt){
			max = cnt
			maxV = right - 2
		}
	}
	return maxV
}







