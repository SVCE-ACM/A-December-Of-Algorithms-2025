define-command treasure-trail-adjustment %{
    evaluate-commands %sh{
        printf '%s\n' "$kak_selection" | awk '
        BEGIN{
            size=0
        }
        NR==1{
            for(i=2;i<=NF;i++){
                nodes[size++]=$i
            }
            n=$1
            next
        }
        END{
            remove_idx=size-n
            
            if(remove_idx<0 || size==0){
                print "echo []"
                exit
            }
            
            result="["
            for(i=0;i<size;i++){
                if(i!=remove_idx){
                    if(result!="[")
                        result=result","
                    result=result nodes[i]
                }
            }
            result=result"]"
            print "echo " result
        }'
    }
}
