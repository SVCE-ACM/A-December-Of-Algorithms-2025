#include <iostream>
#include <vector>
using namespace std;
int R,C;
vector<vector<int>> grid;
void dfs(int i,int j)
{
    if(i<0||i>=R||j<0||j>=C||grid[i][j]==0)
        return;
    grid[i][j]=0;
    dfs(i+1,j);
    dfs(i-1,j);
    dfs(i,j+1);
    dfs(i,j-1);
}
int main()
{
    cin>>R>>C;
    grid.resize(R,vector<int>(C));
    for(int i=0;i<R;i++)
        for(int j=0;j<C;j++)
            cin>>grid[i][j];
    int count=0;
    for(int i=0;i<R;i++)
    {
        for(int j=0;j<C;j++)
        {
            if(grid[i][j]==1)
            {
                count++;
                dfs(i,j);
            }
        }
    }
    cout<<count;
    return 0;
}
