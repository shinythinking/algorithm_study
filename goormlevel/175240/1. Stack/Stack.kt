import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
	val(orders, size) = readLine().split(' ').map{it.toInt()}
	
	val stack = MyStack(size)
	
	for(i in 1..orders){
		val order = readLine()
		if(order[1] == 'o'){
			stack.pop()
		}else {
			val(o, v) = order.split(' ')
			stack.push(v.toInt())
		}
	}
}

class MyStack(val size: Int){
	val arr = IntArray(size)
	var idx = 0
	
	fun push(element: Int){
		if(idx == size){
			println("Overflow")
			return
		}
		
		arr[idx] = element
		idx++
	}
	fun pop(){
		if(idx == 0){
			println("Underflow")
			return
		} else {
			idx--
			println(arr[idx])
		}
	}
}