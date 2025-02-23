fun main() {
    val reader = System.`in`.bufferedReader()
    val (numOfCandidate, num) = reader.readLine().split(" ").map { it.toInt() }
    val votes = IntArray(numOfCandidate + 2)
    val answer = buildString {
        repeat(num) {
            val (opt, numOfVotes, candidate) = reader.readLine().split(" ").map { it.toInt() }
            if (opt == 1) {
                votes[candidate] += numOfVotes
            } else {
                val jung = (votes[numOfCandidate + 1] + numOfVotes)
                val others = Math.ceil(((votes.dropLast(1).sum() + candidate) / numOfCandidate.toDouble()))
                if(jung > others) {
                    appendLine("YES")
                } else {
                    appendLine("NO")
                }
            }
        }
    }
    println(answer)
}