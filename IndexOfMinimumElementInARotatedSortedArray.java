public class IndexOfMinimumElementInARotatedSortedArray {
    
    static int minElementIdx(int[] arr) {      //Linear Search using loops
        if(arr.length==1) return arr[0];
        int idx = 0;
        for(int i = arr.length-1; i>=0; i--) {
            if(arr[i-1]>arr[i]) {
                idx = i;
                break;
            }  
        }
        return idx;
    }

    static int minElementR(int[] arr, int st, int end) {   //Using Recursion 
        if(st==end) return st;
        int mid = st + (end-st)/2;
        int a = minElementR(arr, st, mid); 
        int b = minElementR(arr, mid+1, end);
        if(arr[a]<arr[b]) return a;
        else return b;
    }

    static int minElementIdxB(int[] arr) {      //Binary Search
        int st = 0, end = arr.length-1;
        int mid = st + (end-st)/2;
        int ans = 0;
        //Another Approach....but fails in case of one time rotated array of two elements..ex: {5,3}
        // while(st<=end) {
        //   mid = st + (end-st)/2;
        //   if(arr[mid]<arr[end]) {
        //     ans = mid;
        //     end = mid;
        //   } else st = mid+1;
        // }
        while(st<=end) {
          mid = st + (end-st)/2;
          if(arr[mid]<=arr[arr.length-1]) {
            ans = mid;
            end = mid-1;
          } else st = mid+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {9,10,12,14,16,19,20,3,5,7,8};
        int minIdx = minElementIdxB(arr);
        System.out.println("Index of minimum element in given array : " + minIdx);
    }
}
