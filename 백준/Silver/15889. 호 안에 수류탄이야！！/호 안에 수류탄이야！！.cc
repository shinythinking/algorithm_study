#include <iostream>
#include <sstream>
#include <vector>
#include <string>
using namespace std;

int main() {
    string input;
    getline(cin, input);
    
    vector<int> pos;
    string line;
    getline(cin, line);
    stringstream ss1(line);
    int num;
    while(ss1 >> num) {
        pos.push_back(num);
    }
    
    vector<int> range;
    getline(cin, line);
    stringstream ss2(line);
    while(ss2 >> num) {
        range.push_back(num);
    }
    
    int max = 0;
    bool flag = false;
    
    for(int idx = 0; idx < pos.size(); idx++) {
        int cur = pos[idx];
        if(max >= cur) {
            if(idx < range.size() && max < cur + range[idx]) {
                max = cur + range[idx];
            }
        } else {
            flag = true;
            break;
        }
    }
    
    if(flag) {
        cout << "엄마 나 전역 늦어질 것 같아" << endl;
    } else {
        cout << "권병장님, 중대장님이 찾으십니다" << endl;
    }
    
    return 0;
}