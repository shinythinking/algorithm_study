fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
	val input = readLine().toInt()
	val nums = readLine().split(' ').map{ it.toInt() }
	var answer = 0
	
	var left = 0
	var right = 1
	var sum = nums[left]
	
	while(right < input){
		if(nums[right] == nums[right - 1] + 1){
			sum += nums[right]
		} else {
			left = right
			answer = Math.max(sum, answer)
			sum = nums[left]
		}
		right++
	}
	answer = Math.max(sum, answer)
	print(answer)
}