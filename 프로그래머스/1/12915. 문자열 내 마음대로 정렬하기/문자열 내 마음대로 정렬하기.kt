class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        var strArr = Array(strings.size) {""}
        for((i, str) in strings.withIndex()){
            strArr[i] = "${str[n]}$str"
        }
        strArr = strArr.sorted().map{ it.removeRange(0, 1) }.toTypedArray()
        
        return strArr
    }
}