
#include <iostream>
using namespace std;
int main() {
    int n;
    count=0;
    cout<<"the number :"<<endl;
    cin >> n;
    for(int i=1;i*i<=n;i++)
    {cout << i*i <<" " ;
    count++;
    }
    cout<<"the count is:"<<count<<endl;
    
    return 0;
    
}