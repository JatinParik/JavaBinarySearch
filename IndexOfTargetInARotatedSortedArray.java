public class IndexOfTargetInARotatedSortedArray {
      
    static int binarySearch(int[] arr, int target, int st, int end) {
        int ans = -1;
        while(st<=end) {
            int mid = st + (end-st)/2;
            if(arr[mid]==target) {
                return mid;
            }
            else if(target<arr[mid]) end = mid-1;
            else st = mid+1;
        }
        return ans;
    }
    static int minElementIdxB(int[] arr) {     //Calculation of pivot index
        int st = 0, end = arr.length-1;
        int mid = st + (end-st)/2;
        int ans = 0;
        while(st<=end) {
          mid = st + (end-st)/2;
          if(arr[mid]<=arr[arr.length-1]) {
            ans = mid;
            end = mid-1;
          } else st = mid+1;
        }
        return ans;
    }

    static int findTargetIdx(int[] arr, int target) {  //Calculating target index using pivot index
        int minIdx = minElementIdxB(arr);
        int st,end;
        int ans = -1;
        if(target<=arr[arr.length-1]) {
            st = minIdx;
            end = arr.length-1;
        } else {
            st = 0;
            end = Math.max(0, minIdx-1);
        }
        while(st<=end) {
            int mid = st + (end-st)/2;
            if(target==arr[mid]) {
                ans = mid;
                return ans;
            } else if(target<arr[mid]) end = mid-1;
            else st = mid+1;
        }
        return ans;
    }
    
    static int targetIdx(int[] arr, int target) {    //Calculating target index by using binary search only one time
        int st = 0, end = arr.length-1;
        while(st<=end) {
            int mid = st + (end-st)/2;
            if(target==arr[mid]) return mid;        //target is at mid
            else if(arr[mid]<arr[end]) {           //mid to end is sorted   
                if(target>arr[mid] && target<=arr[end]) st = mid+1;  //target may present in between mid and target
                else end = mid-1;      //target may present outside mid to end
            } else {          //st to mid is sorted
                if(target>=arr[st] && target<arr[mid]) end = mid-1;    //target may present between st and end
                else st = mid+1;     //target may present outside st and end
            }
        }
        return -1;      //target is not present in the given array
    }
       
    //Another Approach
    static int targetIdx2(int[] arr, int target) {   //Not a good approach if target is not present in the array
       int ans = -1;
       int st = 0, end = arr.length-1;
       while(st<=end) {
        int mid = st + (end-st)/2;
        if(target==arr[mid]) return mid;    
        else if(arr[mid]<arr[end]) {        
            if(target>arr[mid] && target<=arr[end]) {    
                ans = binarySearch(arr, target, mid, end);        
                end = mid-1;
            }
            else end = mid-1;        
        } else {           
            if(target>=arr[st] && target<arr[mid]) {       
                ans = binarySearch(arr, target, st, mid);
                st = mid+1;
            }
            else st = mid+1;    
        }
       }
       return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,8,1,3,4};
        int target = 7;
        int ans = targetIdx(arr, target);
        System.out.println("Index of target element is : " + ans);
    }
}
