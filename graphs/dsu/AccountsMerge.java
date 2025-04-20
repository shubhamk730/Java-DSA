package dsu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// 1. Map all the emails to their respective accounts. account name is mapped by index of array
// 2. If email is already present in the map, then union the index of the current account with the index of the account that has the email.
// 3. Else put the email in the map with the index of the current account.
// 4. Create a map containing mergedAccounts
// 5. For each email in the map, find the ultimate parent of the index of the account that has the email and add it to the index.
// 6. Sort the emails in the mergedAccounts map.
// 7. For each entry in the mergedAccounts map, create a new account with the name of the account at the index and add all the emails to it.
// 8. Return the mergedAccounts map.

public class AccountsMerge {

    private AccountsMerge() {
        // Private constructor to prevent instantiation
    }
    
    static ArrayList<ArrayList<String>> accountsMerge(ArrayList<ArrayList<String>> accounts) {
        // code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        for(int i = 0; i < n; i++) {
            ArrayList<String> account = accounts.get(i);
            int as = account.size();
            for(int j = 1; j < as; j++) {
                String email = account.get(j);
                if(map.containsKey(email)) {
                    int upar = map.get(email);
                    ds.unionByRank(upar, i);
                } else {
                    map.put(email, i);
                }
            }
        }
        HashMap<Integer, ArrayList<String>> mergedAccounts = new HashMap<>();

        for(var entry : map.entrySet()) {
            String email = entry.getKey();
            int uparent = ds.findUPar(map.get(email));

            mergedAccounts.computeIfAbsent(uparent, k -> new ArrayList<>()).add(email);

            // if(!mergedAccounts.containsKey(uparent)) {
            //     mergedAccounts.put(uparent, new ArrayList<>());
            // }
            // mergedAccounts.get(uparent).add(email);
        }

        mergedAccounts.values().forEach(Collections::sort);
        

        for(var entry : mergedAccounts.entrySet()) {
            int key = entry.getKey();
            ArrayList<String> account = new ArrayList<>();

            account.add(accounts.get(key).get(0));
            account.addAll(entry.getValue());
            ans.add(account);
        }   


        return ans;
    }
}
