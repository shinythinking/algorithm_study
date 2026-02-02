fun main() {
    val ans = LongArray(26)
    val (r, c) = readln().split(" ").map{it.toInt()}
    val original = List(r) {
        readln()
    }
    val board = List(2) {original}.flatMap{ lines ->
        lines.map{it.repeat(2)}
    }
    for((i,line) in board.withIndex()) {
        for((j,ch) in line.withIndex()) {
            ans[ch-'A'] += (i+1)*(board.size - i).toLong()*(j+1)*(board[0].length - j)
        }
    }
    for(d in ans) {
        println(d)
    }
}