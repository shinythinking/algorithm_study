fun main() {
    val reader = System.`in`.bufferedReader()
    val (guitar, song) = reader.readLine().split(" ").map { it.toInt() }
    val songs = mutableListOf<Long>()

    repeat(guitar) {
        val (guitarName, possibleSong) = reader.readLine().split(" ")
        songs.add(
            possibleSong.map {
                if (it == 'Y') '1' else '0'
            }.joinToString("").toLong(2)
        )
    }
    comb(0L, 0, 0, songs)

    println(maxPair.first)
}

var maxPair: Pair<Int, Int> = Pair(-1, 0)

fun comb(num: Long, idx: Int, currentGuitar: Int, songs: List<Long>) {
    if (idx >= songs.size) return

    val target = songs[idx]
    val newNum = num or target
    val newCnt = count1(newNum)
    val newPair = Pair(currentGuitar + 1, newCnt)
    if (newCnt > maxPair.second) {
        maxPair = newPair
    } else if (newCnt == maxPair.second && currentGuitar < maxPair.first) {
        maxPair = newPair
    }

    comb(num, idx + 1, currentGuitar, songs)
    comb(newNum, idx + 1, currentGuitar + 1, songs)
}

fun count1(num: Long): Int {
    var temp = num
    var cnt = 0
    while (temp != 0L) {
        if (temp and 1L == 1L) cnt++

        temp = temp shr 1
    }
    return cnt
}