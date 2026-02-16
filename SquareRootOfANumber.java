import java.util.Scanner;

public class SquareRootOfANumber {
    
    static int sqrtL(int n) {      //Linear Search (Basic Approach) .... T.C = O(rootn)
         int ans = 0;
         while((ans*ans)<=n) {
            ans++;
         }
         return ans-1;
    }

    static int sqrtB(int n) {     //Binary Search 
        int low = 0, high = n;
        int mid = low + (high-low)/2;
        while(low<=high) {
            mid = low + (high-low)/2;
            int val = mid*mid;
            if(val<=n && (mid+1)*(mid+1)>n) return mid;
            else if(val<n) low = mid+1;
            else high = mid-1;
        }
        return mid;
    }

    //Another Approach
    static int sqrtB2(int n) {     //Binary Search 
        int low = 0, high = n, ans = -1;
        int mid;
        while(low<=high) {
            mid = low + (high-low)/2;
            int val = mid*mid;
            if(val<=n) {
                ans = mid;     
                low = mid+1;
            }  else high = mid-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative number : ");
        int n = sc.nextInt();
        System.out.println("Square root of given number is : " + sqrtL(n));
        System.out.println("Square root of given number is : " + sqrtB(n));
        System.out.println("Square root of given number is : " + sqrtB2(n));
    }
}
