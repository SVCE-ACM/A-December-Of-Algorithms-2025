define-command burn-tree %{
    evaluate-commands %sh{
        printf '%s\n' "$kak_selection" | awk '
        BEGIN{
            target=0
        }
        NR==1{
            target=$1
            next
        }
        {
            for(i=1;i<=NF;i++){
                if($i!="null"){
                    nodes[i-1]=$i
                    parent[i-1]=int((i-2)/2)
                }
            }
            n=NF
        }
        END{
            for(i=0;i<n;i++){
                if(nodes[i]==target){
                    target_idx=i
                    break
                }
            }
            
            visited[target_idx]=1
            current[target_idx]=1
            time=0
            
            while(length(current)>0){
                output=""
                for(idx in current){
                    if(output!="")
                        output=output", "
                    output=output nodes[idx]
                }
                print "echo " output
                
                delete next_level
                for(idx in current){
                    left=2*idx+1
                    right=2*idx+2
                    p=parent[idx]
                    
                    if(left<n && nodes[left]!="" && !visited[left]){
                        visited[left]=1
                        next_level[left]=1
                    }
                    if(right<n && nodes[right]!="" && !visited[right]){
                        visited[right]=1
                        next_level[right]=1
                    }
                    if(p>=0 && nodes[p]!="" && !visited[p]){
                        visited[p]=1
                        next_level[p]=1
                    }
                }
                
                delete current
                for(idx in next_level)
                    current[idx]=1
                time++
            }
        }'
    }
}
