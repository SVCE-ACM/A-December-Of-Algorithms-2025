#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int main()
{
     int n, can = 0;
     cin >> n;

     vector<int> stones(n);
     for (int i = 0; i < n; i++)
     {
          cin >> stones[i];
     }

     for (int i = 0; i < n; i++)
     {
          if (i > can)
          {
               cout << "false";
               return 0;
          }
          can = max(can, i + stones[i]);
     }

     cout << "true";
     return 0;
}
