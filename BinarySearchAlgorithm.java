import java.util.Scanner;

public class BinarySearchAlgorithm {
    
    //Using loops
    static boolean binarySearch(int[] arr, int target) { 
        int st = 0, end = arr.length-1;
        while(st<=end) {
            int mid = st + (end-st)/2;      //In mid = (st+end)/2, st+end can exceed the maximum int value
            if(arr[mid]==target) return true;
            else if(target<arr[mid])  end = mid-1;        
            else st = mid+1;
        }
        return false;
    }

    //Using Recursion
    static boolean binarySearch2(int[] arr, int target, int st, int end) {   //Search target element from st index to end index
        if(st>end)   return false;       //Base Case
        int mid = st + (end-st)/2;
        if(arr[mid]==target) return true;     //Self Work
        else if(target<arr[mid]) return binarySearch2(arr, target, st, mid-1);  //Sub Problem
        else return binarySearch2(arr, target, mid+1, end);   //Sub Problem
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements of Array in a Sorted Manner : ");
        for(int i = 0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter target value : ");
        int target = sc.nextInt();
        if(binarySearch(arr, target)) System.out.println("Yes the target value is present in the given array.");
        else System.out.println("No the target value is not present in the given array.");
        if(binarySearch2(arr, target, 0, arr.length-1)) System.out.println("Yes the target value is present in the given array.");
        else System.out.println("No the target value is not present in the given array.");
    }
}
