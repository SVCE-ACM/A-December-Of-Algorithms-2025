#include <iostream>
#include <iomanip>
#include <sstream>
#include <string>
using namespace std;

string toBinary(int n)
{
     string s = "";
     while (n > 0)
     {
          s = char('0' + (n % 2)) + s;
          n /= 2;
     }
     return (s.size() == 0) ? "0" : s;
}

int main()
{
     int n;
     cin >> n;

     for (int i = 1; i <= n; i++)
     {
          stringstream oct_1, hex_1;
          oct_1 << oct << i;
          hex_1 << hex << uppercase << i;

          cout << setw(5) << i
               << setw(6) << oct_1.str()
               << setw(6) << hex_1.str()
               << setw(6) << toBinary(i)
               << endl;
     }
}
