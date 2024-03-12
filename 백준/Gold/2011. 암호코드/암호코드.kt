import java.io.*;

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){

    var num = readLine()
    if(num.length == 0 || num[0] == '0' || (num[num.lastIndex] == '0' && num[num.lastIndex - 1] >= '3')){
        print(0)
        System.exit(0)
    }
    if(num.length == 1){
        print(1)
        System.exit(0)
    }

    num = "0$num"
    var dp = IntArray(num.length + 1)
    dp[0] = 1
    dp[1] = 1
    for(i in 2..num.lastIndex){
        if(num[i - 1] == '1'){
            if(num[i] > '0'){
                dp[i] = dp[i - 1] + dp[i - 2] % 1000000
            } else {
                dp[i] = dp[i - 2]
            }
        } else if(num[i - 1] == '2'){
            if(num[i] >= '7'){
                dp[i] = dp[i - 1]
            } else if(num[i] == '0'){
                dp[i] = dp[i - 2]
            }else{
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000
            }
        } else{
            if(num[i] == '0'){
                print(0)
                System.exit(0)
            }
            dp[i] = dp[i - 1]
        }
    }
    print((dp[num.length - 1])%1000000)
}
