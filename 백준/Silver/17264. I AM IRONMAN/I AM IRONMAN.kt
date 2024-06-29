import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    val(games, player) = readLine().split(' ').map{ it.toInt() }
    val(win, lose, goal) = readLine().split(' ').map{ it.toInt() }
    val players = mutableMapOf<String, Int>()
    
    repeat(player){
        val temp = readLine().split(' ')
        if(temp[1] == "W")
            players[temp[0]] = win
        else
            players[temp[0]] = -lose
    }
    var sum = 0

    for(i in 1..games){
        val partner = readLine()
        sum += players.getOrDefault(partner, -lose)

        if(sum >= goal){
            print("I AM NOT IRONMAN!!")
            return
        }

        if(sum < 0)
            sum = 0
    }
    print("I AM IRONMAN!!")
}