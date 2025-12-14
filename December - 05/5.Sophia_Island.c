#include<stdio.h>
void dfs(int curr_r, int curr_c, int no_of_rows, int no_of_cols, int grid[no_of_rows][no_of_cols])
{
    if (curr_r < 0 || curr_r >= no_of_rows || curr_c < 0 || curr_c >= no_of_cols)
        return;


    if (grid[curr_r][curr_c] == 0)
        return;

    grid[curr_r][curr_c] = 0;

    dfs(curr_r + 1, curr_c, no_of_rows, no_of_cols, grid); 
    dfs(curr_r - 1, curr_c, no_of_rows, no_of_cols, grid); 
    dfs(curr_r, curr_c + 1, no_of_rows, no_of_cols, grid); 
    dfs(curr_r, curr_c - 1, no_of_rows, no_of_cols, grid); 
}

int main()
{
	int r,c;
	int i,j;
	printf("Enter the no. of rows and cols: ");
	scanf("%d %d", &r, &c);
	int grid[r][c];
	
	printf("Enter the values in the grid: ");
	for(i=0; i<r; i++)
	{
		for(j=0; j<c; j++)
		{
			scanf("%d",&grid[i][j]);
			printf("%d ", grid[i][j]);
		}
		printf("\n");
	}
	int island_count = 0;

    for (i = 0; i < r; i++)
    {
        for (j = 0; j < c; j++)
        {
            if (grid[i][j] == 1)
            {
                island_count++;
                dfs(i, j, r, c, grid);
            }
        }
    }

    printf("Number of islands: %d\n", island_count);

    return 0;
}


	
