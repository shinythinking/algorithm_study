import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
	val (houses, duration) = readLine().split(' ').map{it.toInt()}
	val ground = readLine().split(' ').map{ it.toInt() }.toMutableList()
	ground.add(0, 0)
	val wetHouses = mutableSetOf<Int>()
	
	for(day in 1..duration){
		val(from, to) = readLine().split(' ').map{ it.toInt() }
		for(house in from..to){
			wetHouses.add(house)
			ground[house]++
		}
		
		if(day % 3 == 0){
			for(house in wetHouses)
				ground[house]--
			
			wetHouses.clear()
		}
	}
	
	val answer = StringBuilder()
	for(i in 1..houses)
		answer.append(ground[i]).append(' ')
		
	print(answer)
}