class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        var rank = mutableMapOf<String, Int>()
        
        for((p, player) in players.withIndex()){
            rank[player] = p
        }

        for(calling in callings){
            val secondR = rank[calling]
            val firstR = secondR!! - 1
            val firstP = players[firstR]
            players[firstR] = calling
            players[secondR] = firstP

            rank[calling] = firstR
            rank[firstP] = secondR
        }
        return players
    }
}