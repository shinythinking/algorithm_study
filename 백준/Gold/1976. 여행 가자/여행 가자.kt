import java.io.*
import java.util.*

fun union(left: Int, right: Int){
    val leftP = find(left)
    val rightP = find(right)

    if(leftP == rightP)
        return

    if(leftP < rightP) parent[rightP] = leftP
    else parent[leftP] = rightP
}

fun find(num: Int): Int{
    if(parent[num] == num)
        return num
    return find(parent[num])
}
lateinit var parent: IntArray
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    val numOfCity = readLine().toInt()
    val planCity = readLine().toInt()

    parent = IntArray(numOfCity + 1){ it }

    for(i in 1 until numOfCity){
        val input = "0" + readLine().split(' ').joinToString("")
        for(j in i + 1..numOfCity){
            if(input[j] == '1'){
                union(i, j)
            }
        }
    }

    readLine()
    val cities = readLine().split(' ').map{it.toInt()}

    if(cities.size == 1 && cities[0] != 1){
        print("NO")
        return
    }
    val start = find(cities[0])
    for(city in 1 .. cities.lastIndex){
        if(find(cities[city]) != start){
            print("NO")
            return
        }
    }
    print("YES")
}