fun main() {
    val reader = System.`in`.bufferedReader()
    val target = reader.readLine().toInt()
    val num1 = reader.readLine().toInt()
    val nums1 = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    val num2 = reader.readLine().toInt()
    val nums2 = reader.readLine().split(" ").map { it.toInt() }.toIntArray()

    val sums1 = mutableMapOf<Int, Long>(nums1[0] to 1)
    val sums2 = mutableMapOf<Int, Long>(nums2[0] to 1)

    for(i in 1 until num1) {
        nums1[i] += nums1[i - 1]
        sums1[nums1[i]] = sums1.getOrDefault(nums1[i], 0) + 1
    }

    for(i in 1 until num2) {
        nums2[i] += nums2[i - 1]
        sums2[nums2[i]] = sums2.getOrDefault(nums2[i], 0) + 1
    }

    for(i in 0 until num1) {
        for(j in i + 1 until num1) {
            val tmp = nums1[j] - nums1[i]
            sums1[tmp] = sums1.getOrDefault(tmp, 0) + 1
        }
    }
    for(i in 0 until num2) {
        for(j in i + 1 until num2) {
            val tmp = nums2[j] - nums2[i]
            sums2[tmp] = sums2.getOrDefault(tmp, 0) + 1
        }
    }

    var answer = 0L

    for(p in sums1) {
        answer += p.value * sums2.getOrDefault(target - p.key, 0)
    }

    println(answer)
}