define-command cafeteria-queue-challenge %{
    evaluate-commands %sh{
        printf '%s\n' "$kak_selection" | awk '
        NR==1{
            for(i=1;i<=NF;i++){
                if($i==0) c0++
                else if($i==1) c1++
            }
        }
        NR==2{
            for(i=1;i<=NF;i++){
                s=$i
                if(s==0){
                    if(c0>0) c0--
                    else break
                } else {
                    if(c1>0) c1--
                    else break
                }
            }
        }
        END{
            remaining = c0 + c1
            printf "echo %d\n", remaining
        }'
    }
}
