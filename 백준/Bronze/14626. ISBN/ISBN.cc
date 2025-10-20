#include <iostream>

using namespace std;

int main() {
    string input;
    cin >> input;
    int sum = 0;
    int target = 0;
    int w;
    int arr[] = {0, 7, 4, 1, 8, 5, 2, 9, 6, 3};
    for(int i = 0; i<input.length();i++) {
        char ch = input[i];
        if (i%2==0) w = 1; else w = 3;
        if(ch <= '9' && ch >= '0'){
            sum += (ch - '0') * w;
        } else
        {
            target = w;
        }
    }
    int tmp = 10 - (sum % 10);
    if (tmp == 10) tmp =0;
    if (target == 1)
    {
        cout << tmp << endl;
    } else
    {
        cout << arr[tmp] << endl;
    }

}