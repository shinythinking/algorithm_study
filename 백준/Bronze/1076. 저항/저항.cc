#include <iostream>
#include <string>
#include <vector>
#include <algorithm> 
using namespace std;

int main(){
    vector<string> color = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    
    string color1, color2, color3;
    cin >> color1 >> color2 >> color3;
    
    auto it1 = find(color.begin(), color.end(), color1); 
        auto it2 = find(color.begin(), color.end(), color2);
    auto it3 = find(color.begin(), color.end(), color3);

    int index1 = it1 - color.begin();
    int index2 = it2 - color.begin();
    int index3 = it3 - color.begin();
    
    string answer = to_string(index1 * 10 + index2); 
    if (answer != "0"){ 
        for (int i = 0; i < index3; i++){
            answer += "0";
        }
    }
    
    cout << answer;
}