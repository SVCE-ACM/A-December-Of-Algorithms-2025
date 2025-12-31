#include <iostream>
#include <vector>
using namespace std;
int main()
{
    int n;
    cin>>n;
    if(n%2==0)
    {
        cout<<"Magic square is only possible for odd values of n.";
        return 0;
    }
    vector<vector<int>> magic(n,vector<int>(n,0));
    int i=0;
    int j=n/2;
    for(int num=1;num<=n*n;num++)
    {
        magic[i][j]=num;
        int ni=(i-1+n)%n;
        int nj=(j+1)%n;
        if(magic[ni][nj]!=0)
            i=(i+1)%n;
        else
        {
            i=ni;
            j=nj;
        }
    }
    int M=n*(n*n+1)/2;
    cout<<"Magic constant: "<<M<<endl;
    for(int r=0;r<n;r++)
    {
        for(int c=0;c<n;c++)
            cout<<magic[r][c]<<" ";
        cout<<endl;
    }
    return 0;
}
