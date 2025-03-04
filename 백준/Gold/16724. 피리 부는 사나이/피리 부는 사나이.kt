package shinythinking

import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val (row, col) = reader.readLine().split(" ").map { it.toInt() }
    val map = Array(row) {
        reader.readLine().toCharArray()
    }
    var idx = -col + 1
    val disjointMap = Array(row) {
        idx += col
        IntArray(col) { idx + it }
    }

    val disjointSet = DisjointSet(row * col + 1)

    fun dfs(r: Int, c: Int) {
        val target = when(map[r][c]) {
            'U' -> disjointMap[r-1][c]
            'D' -> disjointMap[r + 1][ c]
            'L' -> disjointMap[r][c - 1]
            else -> disjointMap[r] [c + 1]
        }
        disjointSet.union(disjointMap[r][c], target)

//        if(disjointMap[r][c] == num) {
//
//            return
//        }
//        else {
//            disjointSet.union(disjointMap[r][c], num)
//            return
//        }
//
//        when(map[r][c]) {
//            'U' -> dfs(r - 1, c, num)
//            'D' -> dfs(r + 1, c, num)
//            'L' -> dfs(r, c - 1, num)
//            'R' -> dfs(r, c + 1, num)
//            else -> {
//                disjointMap[r][c] = num
//                disjointSet.union(r * col + c, num)
//            }
//        }
    }
    for(i in 0 until row) {
        for(j in 0 until col) {
            dfs(i, j)
        }
    }
    println(disjointSet.getAmountOfDisjoint())

//    val costs = Array(num) {
//        reader.readLine().split(" ").map { it.toInt() }.toIntArray()
//    }
//    val target = (1 shl num) - 1
//    val dp = Array(num) {
//        Array(num) {
//            IntArray(target + 1) { Int.MAX_VALUE }
//        }
//    }
//
//    val queue = LinkedList<Triple<Int, Int, Int>>()
//
//    for (i in 0 until num) {
//        dp[i][i][0] = 0
//    }
//
//    queue.add(Triple(0, 0, 0))
//    while (queue.isNotEmpty()) {
//        val offered = queue.removeFirst()
//        val from = offered.first
//        val to = offered.second
//        val visited = offered.third
//
//        for ((next, cost) in costs[to].withIndex()) {
//            // 갈 수 없는 곳이라면
//            if (cost == 0) continue
//
//            // next의 bit
//            val bit = (1 shl next)
//            // 방문했던 곳이라면 continue
//            if (visited and bit == bit) continue
//            if (dp[from][next][visited or bit] <= dp[from][to][visited] + cost)
//                continue
//            dp[from][next][visited or bit] = dp[from][to][visited] + cost
//            // 전체를 방문한 것이 아니면 queue에 추가
//            if (visited or bit != target) {
//                queue.add(Triple(from, next, visited or bit))
//            }
//        }
//    }
//    var answer = Int.MAX_VALUE
//    for (i in 0 until num) {
//        answer = Math.min(answer, dp[i][i][target])
//    }
//    println(answer)


//    val tmp = Array(num) {
//        intArrayOf(0) + reader.readLine().split(" ").map { it.toInt() }.toIntArray()
//    }
//    val cost = Array(1) { IntArray(num + 1) } + tmp
//    val memo = Array(num + 1) {
//        IntArray(1 shl (num + 1)) { Int.MAX_VALUE }
//    }
//
//    memo[0][0] = 0
//
//    for(i in 1..num) {
//        for(j in 0 until (1 shl (num + 1))) {
//            if(memo[i - 1][j] == Int.MAX_VALUE) continue
//
//            for(k in 1..num) {
//                if(j and (1 shl k) != 0) continue
//                memo[i][j or (1 shl k)] = Math.min(memo[i][j or (1 shl k)], memo[i - 1][j] + cost[i][k])
//            }
//        }
//    }
//    println(memo[num][(1 shl (num + 1)) - 2])


//    val target = (1 shl 10) - 1
//    val mod = 1_000_000_000
//    val dp = Array(num + 1) {
//        Array(10) {
//            Array(target + 1) { 0 }
//        }
//    }
//
//    for (i in 1..9) {
//        dp[1][i][1 shl i] = 1
//    }
//
//    for (i in 2..num) {
//        for (j in 0..9) {
//            for (k in 0..target) {
//                val bit = k or (1 shl j)
//                when (j) {
//                    0 -> {
//                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k]) % mod
//                    }
//
//                    9 -> {
//                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k]) % mod
//                    }
//
//                    else -> {
//                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k] + dp[i - 1][j - 1][k]) % mod
//                    }
//                }
//            }
//        }
//    }
//    var answer = 0L
//    for(i in 0 until 10) {
//        answer = (answer + dp[num][i][target]) % mod
//    }
//    println(answer)
}

fun euclid(a: Long, b: Long): Long {
    var left = a
    var right = b
    while (right != 0L) {
        val r = left % right
        left = right
        right = r
    }
    return left
}

fun calcDif(a: Array<CharArray>, b: Array<CharArray>): Int {
    var answer = 0
    for (i in 0 until 5) {
        for (j in 0 until 7) {
            if (a[i][j] != b[i][j]) answer++
        }
    }
    return answer
}

fun dijkstra(num: Int, roads: Array<MutableList<Pair<Int, Int>>>, from: Int, to: IntArray): Int {
    val dist = Array(num + 1) { Int.MAX_VALUE }

    val comp = Comparator<Pair<Int, Int>> { o1, o2 -> o1.second - o2.second }
    val pq = PriorityQueue<Pair<Int, Int>>(comp)

    dist[from] = 0
    pq.offer(Pair(from, 0))
    while (pq.isNotEmpty()) {
        val polled = pq.poll()
        val cur = polled.first
        val cost = polled.second

        if (cost > dist[cur]) continue

        for (next in roads[cur]) {
            val newCost = dist[cur] + next.second
            if (newCost < dist[next.first]) {
                dist[next.first] = newCost
                pq.offer(Pair(next.first, newCost))
            }
        }
    }

    var answer = 0
    for (i in to) {
        answer += dist[i]
    }
    return answer
//    return dist.filterIndexed { index, _ ->
//        to.contains(index)
//    }.sumOf { if (it == Int.MAX_VALUE) -1 else it }
}

class DisjointSet(size: Int) {
    private val parent = IntArray(size) { it }
    private val rank = IntArray(size) { 1 }

    fun findSameParent(x: Int): Int {
        val p = find(x)
        return parent.count { it == p }
    }

    fun getAmountOfDisjoint(): Int {
        for (i in 1..parent.lastIndex) {
            find(i)
        }
        return parent.toSet().size - 1
    }

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)

        if (rootY != rootX) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY
            } else {
                parent[rootY] = rootX
                rank[rootX] += 1
            }
        }
    }
}

fun confirmAllConnected(disjointSet: DisjointSet, num: Int): Boolean {
    val prev: Int = disjointSet.find(1)
    for (i in 2..num) {
        if (prev != disjointSet.find(i))
            return true
    }
    return false
}

fun calcDist(a: Pair<Int, Int>, b: Pair<Int, Int>): Double {
    return Math.sqrt((a.first - b.first).toDouble() * (a.first - b.first) + (a.second - b.second).toDouble() * (a.second - b.second))
}

fun upperbound(list: IntArray, target: Int): Int {
    var left = 0
    var right = list.size

    while (left < right) {
        val mid = left + (right - left) / 2

        if (list[mid] <= target) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}

fun lowerbound(list: IntArray, target: Int): Int {
    var left = 0
    var right = list.size

    while (left < right) {
        val mid = left + (right - left) / 2

        if (target > list[mid]) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}

fun getPermutation(sum: Int, index: Int, sums: MutableList<Int>, elements: Array<Int>) {
    if (index == elements.size) {
        sums.add(sum)
        return
    }

    getPermutation(sum, index + 1, sums, elements)
    getPermutation(sum + elements[index], index + 1, sums, elements)
}

fun getUpperBound(list: List<Int>, target: Int): Int {
    var left = 0
    var right = list.size
    while (left < right) {
        val mid = (left + right) / 2

        if (list[mid] > target) {
            right = mid
        } else {
            left = mid + 1
        }
    }

    return left
}

fun getSums(sum: Int, cur: Int, end: Int, group: List<Int>, sums: MutableList<Int>, limit: Int) {
    if (cur == end) {
        sums.add(sum)
        return
    }

    val temp = sum + group[cur]
    if (temp in 0..limit) {
        getSums(temp, cur + 1, end, group, sums, limit)
    }
    getSums(sum, cur + 1, end, group, sums, limit)
}

fun getPrimeNums(num: Int): List<Int> {
    val isPrime = BooleanArray(num + 1) { true }
    isPrime[0] = false
    isPrime[1] = false
    for (i in 2..num) {
        if (isPrime[i]) {
            if (i <= num / i) {
                for (j in i * i..num step i) {
                    isPrime[j] = false
                }
            }
        }
    }

    return isPrime.withIndex().filter { it.value }.map { it.index }
}

class DisjointSet1(size: Int) {
    private val parent = IntArray(size) { it }
    private val rank = IntArray(size) { 1 }
    private val size = IntArray(size) { 1 }

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(x: Int, y: Int): Int {
        val rootX = find(x)
        val rootY = find(y)

        if (rootY != rootX) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX
                size[rootX] += size[rootY]
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY
                size[rootY] += size[rootX]
            } else {
                parent[rootY] = rootX
                size[rootX] += size[rootY]
                rank[rootX] += 1
            }
        }
        return size[find(x)]
    }
}

fun combi(n: Int, k: Int): Int {
    if (n < k) return 0
    val num = k.coerceAtMost(n - k)
    var result = 1
    for (i in 1..num) {
        result = result * (n - i + 1) / i
    }
    return result
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

fun binarySearch(list: List<Pair<Double, Double>>, target: Pair<Double, Double>): Int {
    var left = 0
    var right = list.lastIndex

    while (left < right) {
        val mid = (left + right) / 2
        if (list[mid] == target) {
            return mid
        } else if (isSecondDiaBetter(list[mid], target)) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return right
}

fun isSecondDiaBetter(first: Pair<Double, Double>, second: Pair<Double, Double>): Boolean {
    return first.first < second.first && first.second > second.second
}

val idxList = mutableListOf<Int>()

fun postOrder(left: Int, right: Int) {
    val m = (left + right) / 2
    if (left < right) {
        postOrder(left, m)
        postOrder(m + 1, right)
        idxList.add(m)
    }
}

fun findCommonBiggest(listA: List<Int>, listB: List<Int>): Int {
    val sortedSetA = listA.toSortedSet(reverseOrder())
    val sortedSetB = listB.toSortedSet(reverseOrder())
    while (sortedSetA.size != 0 && sortedSetB.size != 0) {
        val a = sortedSetA.first()
        val b = sortedSetB.first()

        if (a == b) {
            return a
        } else if (a > b) {
            sortedSetA.remove(a)
        } else {
            sortedSetB.remove(b)
        }
    }
    return -1
}

fun combination(n: Int, k: Int): Int {
    if (k == 0 || k == n) return 1
    var result = 1
    for (i in 1..k) {
        result = result * (n - i + 1) / i
    }
    return result
}