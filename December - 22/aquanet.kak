define-command aquanet %{
    evaluate-commands %sh{
        printf '%s\n' "$kak_selection" | awk '
        NR==1{
            V=$1
            E=$2
            for(i=0;i<V;i++){
                adj[i]=""
            }
            next
        }
        NR<=E+1{
            u=$1
            v=$2
            if(adj[u]=="")
                adj[u]=v
            else
                adj[u]=adj[u]" "v
            if(adj[v]=="")
                adj[v]=u
            else
                adj[v]=adj[v]" "u
            next
        }
        {
            for(i=1;i<=NF;i++){
                state[i-1]=$i
            }
        }
        END{
            for(i=0;i<V;i++){
                if(state[i]==0)
                    empty++
            }
            
            if(empty==0){
                print "echo 0"
                exit
            }
            
            time=0
            while(empty>0){
                changed=0
                for(i=0;i<V;i++){
                    if(state[i]==1){
                        n=split(adj[i],neighbors," ")
                        for(j=1;j<=n;j++){
                            nb=neighbors[j]
                            if(state[nb]==0){
                                new_state[nb]=1
                                changed=1
                            }
                        }
                    }
                }
                
                if(changed==0){
                    print "echo -1"
                    exit
                }
                
                for(i=0;i<V;i++){
                    if(new_state[i]==1){
                        state[i]=1
                        empty--
                        delete new_state[i]
                    }
                }
                time++
            }
            
            print "echo " time
        }'
    }
}
