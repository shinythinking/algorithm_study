#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    cin >> n;
    int arr[n];
    int tmp = 0;
    vector<bool> isFull(n, false);
    for(int i = 0 ; i < n ; i++) {
        cin >> tmp;
        int idx = 0;
        while(tmp!=-1) {
            if(!isFull[idx++]) tmp--;
        }
        isFull[idx-1] = true;
        arr[idx-1] = i+1;

    }

    for (const auto& d : arr) {
        cout << d << " ";
    }

}