define-command mountain-climber %{
    evaluate-commands %sh{
        printf '%s\n' "$kak_selection" | awk '
        NR==1{
            M=$1
            N=$2
            row=0
            next
        }
        {
            for(i=1;i<=NF;i++){
                grid[row,i-1]=$i
            }
            row++
        }
        END{
            max_len=1
            
            for(r=0;r<M;r++){
                for(c=0;c<N;c++){
                    len=dfs(r,c)
                    if(len>max_len)
                        max_len=len
                }
            }
            
            print "echo " max_len
        }
        
        function dfs(r,c){
            if((r,c) in memo)
                return memo[r,c]
            
            max_path=1
            dx[0]=0; dx[1]=0; dx[2]=1; dx[3]=-1
            dy[0]=1; dy[1]=-1; dy[2]=0; dy[3]=0
            
            for(i=0;i<4;i++){
                nr=r+dx[i]
                nc=c+dy[i]
                
                if(nr>=0 && nr<M && nc>=0 && nc<N && grid[nr,nc]>grid[r,c]){
                    path=1+dfs(nr,nc)
                    if(path>max_path)
                        max_path=path
                }
            }
            
            memo[r,c]=max_path
            return max_path
        }'
    }
}
