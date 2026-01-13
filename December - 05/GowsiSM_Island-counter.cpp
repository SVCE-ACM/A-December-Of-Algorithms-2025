#include <iostream>
#include <vector>
using namespace std;

int main(){
     int r, c;
     cin>> r>> c;
     vector<vector<bool>> visited;
     vector<vector<int>> arr(vector<int>(c));
     for(int i = 0; i < r; i++){
          for(int j = 0; j < c; j++){
               cin>> arr[i][j];
          }
     }
}