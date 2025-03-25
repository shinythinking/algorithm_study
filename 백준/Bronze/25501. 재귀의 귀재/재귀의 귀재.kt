fun main() {
    val reader = System.`in`.bufferedReader()
    val testcase = reader.readLine().toInt()

    var str: String = ""
    var ans: Int = 0
    fun isPalindrome(left: Int, right: Int): Int {
        ans++
        return if (left >= right) 1
        else if (str[left] != str[right]) 0
        else isPalindrome(left + 1, right - 1)
    }

    val answer = buildString {
        repeat(testcase) {
            ans = 0
            str = reader.readLine()

            appendLine("${isPalindrome(0, str.lastIndex)} $ans")
        }
    }

    println(answer)
}