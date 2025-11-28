#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    int arr[n];
    for(int i = 0 ; i < n ; i++) cin >> arr[i];
    if (n == 1) {
        cout << 1;
        return 0;
    }
    int tmp = 1;
    int max = 0;
    for(int i = 1 ; i < n ; i++) {
        if(arr[i] >= arr[i-1]) tmp++;
        else tmp = 1;

        if(max < tmp) max = tmp;
    }
    tmp = 1;

    for(int i = 1 ; i < n ; i++) {
        if(arr[i - 1] >= arr[i]) {
            tmp++;
        }
        else {
            tmp = 1;
        }

        if(max < tmp) max = tmp;
    }
    tmp = 1;

    cout << max;
}