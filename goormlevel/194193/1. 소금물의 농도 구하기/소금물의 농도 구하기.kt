import java.io.*
import java.util.*

fun main(args: Array<String>) {
	val (saltWater, water) = readLine()!!.split(' ').map{ it.toFloat() }
	
	val salt = saltWater * 7.0 / 100.0
	print( String.format("%.2f",(salt * 10000 / (saltWater + water)).toInt()/100.0))
}