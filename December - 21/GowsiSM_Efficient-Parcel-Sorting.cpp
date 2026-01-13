#include <iostream>
#include <deque>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;

int main(){
     int n;
     cin>> n;
     deque<int> q;
     for(int i = 0; i < n; i++){
          int x;
          cin>> x;
          q.push_back(x);
     }
     vector<int> res;
     while(!q.empty()){
          int num = *min_element(q.begin(), q.end());
          while(num != q.front()){
               q.push_back(q.front());
               q.pop_front();
          }
          res.push_back(q.front());
          q.pop_front();
     }
     for(int val: res){
          cout<<val<< " ";
     }
}