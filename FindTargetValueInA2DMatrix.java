public class FindTargetValueInA2DMatrix {
   
    static boolean binarySearch(int[] arr, int target) {
        int st = 0, end = arr.length;
        while(st<=end) {
            int mid = st + (end-st)/2;
            if(target==arr[mid]) return true;
            else if(target<arr[mid]) end = mid-1;
            else st = mid+1;
        }
        return false;
    } 

    static boolean search(int[][] arr, int target) {      //Time complexity = O(mlogn)...m=number of rows..n=number of columns
        for(int i = 0; i<arr.length; i++) {
            if(binarySearch(arr[i], target)) return true;
        }
        return false;
    }

    static boolean searchTarget(int[][] arr, int target) {     //Time complexity = O(logm + logn)
        int r = arr.length;   //rows
        int c = arr[0].length;   //columns
        int st = 0, end = r-1;
        int rowN = -1;   //row number of target element
        while(st<=end) {
            int mid = st + (end-st)/2;
            if(target<=arr[mid][c-1] && target>=arr[mid][0]) {
                rowN = mid;
                break;
            }
            else if(target<arr[mid][0]) end = mid-1;
            else st = mid+1;
        } 
        if(rowN>=0) {
            st = 0;
            end = c-1;
            while(st<=end) {        //can be written inside first if condition of upper while loop
                int mid = st + (end-st)/2;
                if(target==arr[rowN][mid]) return true;
                else if(target<arr[rowN][mid]) end = mid-1;
                else st = mid+1;
            }
        } 
        return false;
    }

    static boolean searchTarget2(int[][] a, int target) {   //considering the 2D matrix a single sorted array with intitial index as 0 and last index as rows*columns-1
          int r = a.length, c = a[0].length;
          int st = 0, end = r*c-1;  
          while(st<=end) {
            int mid = st + (end-st)/2;
            int rN = mid/c;  //row number of element at mid
            int cN = mid%c;  //column number of element at mid
            if(target==a[rN][cN]) return true;
            else if(target>a[rN][cN]) st = mid+1;
            else end = mid-1;
          }
          return false;
    }


    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7}, {10,11,16,20},{23,30,34,60}};
        int target = 31;
        System.out.println(searchTarget2(arr, target));
    }
}
