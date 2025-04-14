fun main() {
    val reader = System.`in`.bufferedReader()
    val (target, num) = reader.readLine()!!.split(' ').map { it.toInt() }
    val nums = reader.readLine().split(" ").map { it.toInt() }.sorted()

    fun getUpperbound(t: Int): Int {
        var left = 0
        var right = nums.size
        while (left < right) {
            val mid = (left + right) / 2
            if (nums[mid] <= t) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }

    val str = target.toString()
    val answer = buildString {
        for (ch in str) {
            val index = getUpperbound(ch - '0') - 1

            if(index < 0) {
                while(isNotEmpty()){
                    val tmp = getUpperbound(last() - '0')
                    deleteCharAt(lastIndex)
                    if(tmp - 2 >= 0) {
                        append(nums[tmp - 2])
                        repeat(str.length - length){
                            append(nums.last())
                        }
                        break
                    }
                }

                if(isEmpty()){
                    repeat(str.length - length - 1) {
                        append(nums.last())
                    }
                }
                break
            }
            if(nums[index]  == ch - '0') append(ch)
            else {
                append(nums[index])
                repeat(str.length - length){
                    append(nums.last())
                }
                break
            }
        }
    }

    println(answer)
}