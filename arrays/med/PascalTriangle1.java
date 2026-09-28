package arrays.med;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle1 {
    private int getVal(int r, int c) {
        // Dont calculate full factorial as it will get cancelled, only use first 'r' numbers in numerator and denominator,rest will get cancelled
        int ans = 1;
        for(int i = 0; i < c; i++) {
            ans = ans * (r - i);
            ans = ans/(i+1);

        }

        return ans;
    }


    int pascalTriangleI(int r, int c) {

        return getVal(r - 1, c- 1);
    }

    public int[] pascalTriangleII(int r) {
        int[] ans = new int[r];

        for(int i = 0; i < r; i++) {
            ans[i] = getVal(r - 1, i);
        }

        return ans;
    }

    public List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();

            for(int j = 0; j <= i; j++) {
                row.add(getVal(i, j));
            }
            ans.add(row);
            
        }

        return ans;
    }

    public static void main(String[] args) {
        
    }   
}
