define-command tower-visibility %{
    evaluate-commands %sh{
        printf '%s\n' "$kak_selection" | awk '
        NR==1{
            N=$1
            next
        }
        {
            for(i=1;i<=NF;i++){
                heights[i-1]=$i
            }
            n=NF
        }
        END{
            result=""
            for(i=0;i<n;i++){
                nge=-1
                for(j=i+1;j<n;j++){
                    if(heights[j]>heights[i]){
                        nge=heights[j]
                        break
                    }
                }
                if(result!="")
                    result=result" "
                result=result nge
            }
            print "echo " result
        }'
    }
}
