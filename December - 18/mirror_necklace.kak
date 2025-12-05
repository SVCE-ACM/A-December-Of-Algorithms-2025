define-command mirror-necklace %{
    evaluate-commands %sh{
        printf '%s\n' "$kak_selection" | awk '
        NR==1{
            N=$1
            if(N==0){
                print "echo The necklace is empty."
                exit
            }
            next
        }
        {
            for(i=1;i<=NF;i++){
                beads[i]=$i
            }
            n=NF
        }
        END{
            is_palindrome=1
            for(i=1;i<=int(n/2);i++){
                if(beads[i]!=beads[n-i+1]){
                    is_palindrome=0
                    break
                }
            }
            
            if(is_palindrome)
                print "echo The necklace is mirrored."
            else
                print "echo The necklace is not mirrored."
        }'
    }
}
