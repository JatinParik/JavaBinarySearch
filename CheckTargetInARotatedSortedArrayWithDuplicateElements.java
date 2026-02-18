public class CheckTargetInARotatedSortedArrayWithDuplicateElements {
    
    static boolean search(int[] arr, int target) {
        int st = 0, end = arr.length-1;
        while(st<=end) {
            int mid = st + (end-st)/2;
            while(arr[st]==arr[mid] && arr[mid]==arr[end] && arr[mid]!=target) {
                st++;
                end--;
            }
            if(st>end) return false;
            if(arr[mid]==target) return true;     //mid will remain same
            else if(arr[st]==arr[mid] && arr[mid]!=arr[end]) {
                if(arr[mid]<arr[end]) {
                    if(target>arr[mid] && target<=arr[end]) st = mid+1;
                    else end = mid-1;
                } else {
                    if(target>=arr[st] && target<arr[mid]) end = mid-1;
                    else st = mid+1;
                }
            } else if(arr[st]!=arr[mid] && arr[mid]==arr[end]) {
                if(arr[st]<arr[mid]) {
                    if(target>=arr[st] && target<arr[mid]) end = mid-1;
                    else st = mid+1;
                } else {
                    if(target>arr[mid] && target<=arr[end]) st = mid+1;
                    else end = mid-1;
                }
            } else {
                if(arr[st]<arr[mid]) {
                    if(target>=arr[st] && target<arr[mid]) end = mid-1;
                    else st = mid+1;
                } else {
                    if(target>arr[mid] && target<=arr[end]) st = mid+1;
                    else end = mid-1;
                }
            }
        }
        return false;
    }
    
    //Another approach (more logical)
    static boolean searchTarget(int[] arr, int target) {
        int st = 0, end = arr.length-1;
        while(st<=end) {
            int mid = st + (end-st)/2;
            while(arr[st]==arr[mid] && arr[mid]==arr[end] && target!=arr[mid]) {
                st++;
                end--;
            }
            if(st>end) return false;
            if(target==arr[mid]) return true;      //mid will remain same
            else if(arr[st]==arr[mid] && arr[mid]!=arr[end]) {     //st to mid will surely be sorted and all elements from st to mid will be same
                st = mid+1;
            } else if(arr[st]!=arr[mid] && arr[mid]==arr[end]) {   //mid to end will surely be sorted and all elements from mid to end will be same
                end = mid-1;
            } else if(arr[st]!=arr[mid] && arr[mid]!=arr[end]) {   //have to check which part is sorted
                if(arr[st]<arr[mid]) {  //st to mid is sorted
                    if(target>=arr[st] && target<arr[mid]) end = mid-1;    //target may be present between st to mid
                    else st = mid+1;
                } else {      //mid to end is sorted
                    if(target>arr[mid] && target<=arr[end]) st = mid+1;    //target may be present between mid to end
                    else end = mid-1;
                }
            }
        } 
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {3,3,4,5,3,3,3,3,3,3,3,3 };
        int target = 4;
        System.out.println(searchTarget(arr, target));
    }
}
