public class PeakIndexInAMountainArray {
    
    static int peakIdx(int[] arr) {
        int st = 0, end = arr.length-1;
        while(st<=end) {
            int mid = st + (end-st)/2;
            if((mid==0 || arr[mid-1]<arr[mid]) && arr[mid]>arr[mid+1]) return mid;
            else if(arr[mid]<arr[mid+1]) st = mid+1;
            else end = mid-1;  
        }
        return -1;
    }
    //Another Approach
    static int peakIdx2(int[] arr) {
        int st = 0, end = arr.length-1;
        int ans = -1;
        while(st<=end) {
            int mid = st + (end-st)/2;
            if(arr[mid]<arr[mid+1]) {
                ans = mid+1;
                st = mid+1;
            } else end = mid-1;   
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {5, 9, 4, 3, 2, 1};
        System.out.println("Peak index : " + peakIdx(arr));
    }
}
