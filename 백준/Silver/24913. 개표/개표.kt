fun main() {
    val reader = System.`in`.bufferedReader()
    val (numOfCandidate, num) = reader.readLine().split(" ").map { it.toInt() }
    val votes = LongArray(numOfCandidate + 2)
    var sumOfOthers = 0L
    var maxVote = 0L
    val answer = buildString {
        repeat(num) {
            val (opt, numOfVotes, candidate) = reader.readLine().split(" ").map { it.toInt() }
            if (opt == 1) {
                votes[candidate] += numOfVotes.toLong()
                if(candidate != numOfCandidate + 1) {
                    sumOfOthers += numOfVotes
                    maxVote = maxOf(maxVote, votes[candidate])
                }
            } else {
                if(maxVote >= votes[numOfCandidate + 1] + numOfVotes) { appendLine("NO") }
                else {
                    if(sumOfOthers + candidate <= (numOfCandidate) * (votes[numOfCandidate + 1] + numOfVotes - 1)) {
                        appendLine("YES")
                    } else {
                        appendLine("NO")
                    }
                }
            }
        }
    }
    println(answer)
}