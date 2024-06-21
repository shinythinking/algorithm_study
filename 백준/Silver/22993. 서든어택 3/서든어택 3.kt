import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val num = readLine()
    val players = readLine().split(' ').map{ it.toLong() }
    
    var player = players[0]
    val enemies = players.slice(1..players.lastIndex).sorted()
    
    for(enemy in enemies){
       if(player > enemy)
            player += enemy
        else{
            print("No")
            return
        }
    }
    print("Yes")
}