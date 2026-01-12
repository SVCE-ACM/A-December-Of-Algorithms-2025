#include <iostream>
#include <iomanip>
#include <bitset>
using namespace std;
int binaryWidth(int n) 
{
    int width = 0;
    while (n > 0) 
    {
        width++;
        n /= 2;
    }
    return width;
}
int main() 
{
    int N;
    cin >> N;
    int width = binaryWidth(N);
    for (int i = 1; i <= N; i++) 
    {
        // Decimal
        cout << setw(width) << dec << i << " ";
        // Octal
        cout << setw(width) << oct << i << " ";
        // Hexadecimal (uppercase)
        cout << setw(width) << uppercase << hex << i << " ";
        // Binary
        cout << setw(width) << bitset<32>(i).to_string().substr(32 - width);
        cout << endl;
    }
    return 0;
}
