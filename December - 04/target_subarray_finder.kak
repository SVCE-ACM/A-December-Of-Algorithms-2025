define-command target-subarray-finder %{
    evaluate-commands %sh{
        printf '%s\n' "$kak_selection" | awk '
        BEGIN{
            pos=0
            prefix=0
            start=-1
            end=-1
            seen[0]=0
        }
        NR==1{
            N=$1
            K=$2
            next
        }
        {
            for(i=1;i<=NF && pos<N;i++){
                val=$i
                pos++
                prefix+=val
                needed=prefix-K
                if((needed in seen) && start<0){
                    start=seen[needed]
                    end=pos-1
                }
                if(!(prefix in seen)){
                    seen[prefix]=pos
                }
            }
        }
        END{
            if(start<0)
                print "echo -1 -1"
            else
                printf "echo %d %d\n", start, end
        }'
    }
}
