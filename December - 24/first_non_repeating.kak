define-command first-non-repeating %{
    evaluate-commands %sh{
        printf '%s\n' "$kak_selection" | awk '
        {
            s=$0
            n=length(s)
            
            for(i=1;i<=n;i++){
                c=substr(s,i,1)
                count[c]++
                if(!(c in order))
                    order[c]=i
            }
            
            found=0
            for(i=1;i<=n;i++){
                c=substr(s,i,1)
                if(count[c]==1){
                    print "echo The first non-repeating character is: " c
                    found=1
                    break
                }
            }
            
            if(!found)
                print "echo No non-repeating character found."
        }'
    }
}
