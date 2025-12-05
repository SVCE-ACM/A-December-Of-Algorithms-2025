define-command zig-zag-linked-list %{
    evaluate-commands %sh{
        printf '%s\n' "$kak_selection" | awk '
        NR==1{
            n=$1
        }
        NR==2{
            for(i=1;i<=NF && i<=n;i++){
                a[i]=$i
            }
        }
        END{
            if(n==0){
                print "echo"
                exit
            }
            left=1
            right=n
            out=""
            while(left<=right){
                if(out!="") out=out" "
                out=out a[left]
                if(left==right) break
                out=out" "a[right]
                left++
                right--
            }
            printf "echo %s\n", out
        }'
    }
}
