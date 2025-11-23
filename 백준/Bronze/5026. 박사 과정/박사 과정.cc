#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    for(int i = 0 ; i<n ; i++ ) {
        string input;
        cin >> input;
        if(input == "P=NP")
            cout << "skipped\n";
        else  {
            int idx = 0;

            while (input[idx] != '+') idx++;
            string left = input.substr(0, idx);
            string right = input.substr(idx + 1);
            cout << stoi(left) + stoi(right) << "\n";
        }
    }
}