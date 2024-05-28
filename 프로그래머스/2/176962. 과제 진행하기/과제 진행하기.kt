import java.util.*

class Solution {
    data class Task( val name: Int, var time: Int)
    
    fun solution(plans: Array<Array<String>>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        
        val stack = ArrayDeque<Task>()
        val stringArr = mutableListOf<String>()
        val planList = plans.sortedWith( compareBy { it[1] } ).map{
            val times = it[1].split(':').map{ it.toInt() }
            stringArr += it[0]
            arrayOf(stringArr.lastIndex, times[0] * 60 + times[1], it[2].toInt())
        }
        
        var previousPlan = planList[0]
        for(i in 1..planList.lastIndex){
            val timePassed = planList[i][1] - previousPlan[1]
            var timeLeft = previousPlan[2] - timePassed
            when{
                timeLeft == 0 ->{
                    answer += stringArr[previousPlan[0]]
                }
                timeLeft > 0 -> {
                    stack.push(Task(previousPlan[0], timeLeft))
                }
                else -> {
                    answer += stringArr[previousPlan[0]]
                    while(stack.isNotEmpty()){
                        val processedTask = stack.pop()
                        processedTask.time += timeLeft
                        
                        when{
                            processedTask.time == 0 -> {
                                answer += stringArr[processedTask.name]
                                break
                            }
                            processedTask.time > 0 ->{
                                stack.push(processedTask)
                                break
                            }
                            else -> {
                                answer += stringArr[processedTask.name]
                                timeLeft = processedTask.time
                                continue
                            }
                        }
                    }
                }
            }
            previousPlan = planList[i]
        }
        
        answer += stringArr[previousPlan[0]]
        
        while(stack.isNotEmpty())
            answer += stringArr[stack.pop().name]
        
        return answer
    }
}