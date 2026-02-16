import java.util.Scanner;

public class LastOccurenceOfTarget {
    
    static int lastOccurence(int[] arr, int target) {
        int st = 0, end = arr.length-1;
        int idx = -1;
        while(st<=end) {
            int mid = st + (end-st)/2;
           if(arr[mid]==target) {
             idx = mid;
             st = mid+1;
           } else if(target<arr[mid]) end = mid-1;
           else st = mid+1;
        }   
        return idx; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements of array in a sorted manner : ");
        for(int i = 0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter Target value : ");
        int target = sc.nextInt();
        int ans = lastOccurence(arr, target);
        System.out.println("Last occurence of " + target + " in given array is at index : " + ans);
    }
}
