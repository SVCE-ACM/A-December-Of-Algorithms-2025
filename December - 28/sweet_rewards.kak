define-command sweet-rewards %{
    evaluate-commands %sh{
        printf '%s\n' "$kak_selection" | awk '
        NR==1{
            n=$1
            next
        }
        {
            for(i=1;i<=NF;i++){
                scores[i-1]=$i
            }
        }
        END{
            for(i=0;i<n;i++){
                left[i]=1
                right[i]=1
            }
            
            for(i=1;i<n;i++){
                if(scores[i]>scores[i-1])
                    left[i]=left[i-1]+1
            }
            
            for(i=n-2;i>=0;i--){
                if(scores[i]>scores[i+1])
                    right[i]=right[i+1]+1
            }
            
            total=0
            for(i=0;i<n;i++){
                candy=left[i]>right[i]?left[i]:right[i]
                total+=candy
            }
            
            print "echo " total
        }'
    }
}
