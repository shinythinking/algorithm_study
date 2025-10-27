#include <iostream>

using namespace std;

bool che(int num) {
    static bool isNotPrime[10002] = {};
    static int cur = 2;

    for(;cur <= num;cur++){
        if(!isNotPrime[cur]) {
            int idx = cur;
            while(cur * idx <= 10001){
                isNotPrime[cur * idx] = true;
                idx++;
            }
        }
    }
    return !isNotPrime[num];
}

int main() {
    int tc;
    cin >> tc;

    for(int i = 0 ; i < tc ; i++) {
        int n;
        cin >> n;
        if(che(n + 1)){
            cout << 1 << '\n' << "1 " << n+1 <<"\n";
        } else cout << "0" << "\n";
    }
}