define-command missing-positive %{
    evaluate-commands %sh{
        printf '%s\n' "$kak_selection" | awk '
        NR==1{
            N=$1
            next
        }
        {
            for(i=1;i<=NF;i++){
                arr[i]=$i
            }
        }
        END{
            sum=0
            sum_sq=0
            actual_sum=0
            actual_sum_sq=0
            
            for(i=1;i<=N;i++){
                sum+=i
                sum_sq+=i*i
                actual_sum+=arr[i]
                actual_sum_sq+=arr[i]*arr[i]
            }
            
            diff_sum=actual_sum-sum
            diff_sum_sq=actual_sum_sq-sum_sq
            
            duplicate=(diff_sum_sq/diff_sum+diff_sum)/2
            missing=duplicate-diff_sum
            
            printf "echo Missing Number: %d\n", missing
            printf "echo Duplicate Number: %d\n", duplicate
        }'
    }
}
