package basic_math;

// gcd/hcf(n1.n2) -> gcd(n1-n2,n2)  n1>n2
public class euclidean_algo {

    // private static int gcd(int n1, int n2) {
        
    //     for(int i = Math.min(n1, n2); i >= 1; i--) {
    //         if(n1 % i == 0 && n2 % i == 0){
    //             return i;
    //         }    
    //     }

    //     return 1;
    // }


     // Continue loop as long as both
    // a and b are greater than 0
    // TC -> O(log(phi)(min(a,b)))
    public static int findGcd(int a, int b) {
        while(a > 0 && b > 0) {
            // If a is greater than b,
            // subtract b from a and update a
            if(a > b) {
                // Update a to the remainder
                // of a divided by b
                a = a % b;
            }
            // If b is greater than or equal
            // to a, subtract a from b and update b
            else {
                // Update b to the remainder
                // of b divided by a
                b = b % a;
            }
        }
        // Check if a becomes 0,
        // if so, return b as the GCD
        if(a == 0) {
            return b;
        }
        // If a is not 0,
        // return a as the GCD
        return a;
    }

    public static void main(String[] args) {
        int n1 = 20;
        int n2 = 15;
        int diff = n1 - n2;

        int ans = findGcd(diff, n2);

        System.out.println("GCD of numbers is : " + ans);

    }
}
