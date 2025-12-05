define-command magic-square-odd %{
    evaluate-commands %sh{
        printf '%s\n' "$kak_selection" | awk '
        NR==1{
            n=$1
        }
        END{
            if(n % 2 == 0){
                print "echo Magic square is only possible for odd values of n."
                exit
            }
            for(i=1;i<=n;i++){
                for(j=1;j<=n;j++){
                    a[i,j]=0
                }
            }
            i=1
            j=int(n/2)+1
            for(num=1; num<=n*n; num++){
                a[i,j]=num
                ni=i-1
                nj=j+1
                if(ni<1) ni=n
                if(nj>n) nj=1
                if(a[ni,nj]!=0){
                    i=i+1
                    if(i>n) i=1
                } else {
                    i=ni
                    j=nj
                }
            }
            M = n * (n*n + 1) / 2
            printf "echo Magic constant: %d\n", M
            for(i=1;i<=n;i++){
                line=""
                for(j=1;j<=n;j++){
                    if(j>1) line=line" "
                    line=line a[i,j]
                }
                printf "echo %s\n", line
            }
        }'
    }
}
