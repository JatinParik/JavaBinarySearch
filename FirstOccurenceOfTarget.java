import java.util.Scanner;

public class FirstOccurenceOfTarget {
    
    static int firstOccurence(int[] arr, int target) {
        int st = 0, end = arr.length-1;
        int idx = -1;
        while(st<=end) {
            int mid = st + (end-st)/2;
           if(arr[mid]==target) {
             idx = mid;
             end = mid-1;
            // Another Way
            //  if(mid>0 && arr[mid-1]==target) end = mid-1;
            //  else {
            //     idx = mid;
            //     return idx;
            //  }
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
        int ans = firstOccurence(arr, target);
        System.out.println("First occurence of : " + target + " in given array is at index : " + ans);
    }
}
