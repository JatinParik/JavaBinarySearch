public class FindPeakElement {
    
    static int peakElement(int[] a) {
        if(a.length==1) return 0;
        int st = 0, end = a.length-1;
        if(a[0]>a[1]) return 0;
        else if(a[a.length-2]<a[a.length-1]) return a.length-1;
        while(st<=end) {
            int mid = st + (end-st)/2;
            if(a[mid-1]<a[mid] && a[mid]>a[mid+1]) return mid;
            else if(a[mid]<a[mid+1]) st = mid+1;    //uphill
            else end = mid;   //downhill
        }
        //Another Approach  (Don't have to write any other if else conditions)
        // while(st<=end) {
        //     int mid = st + (end-st)/2;
        //     if((mid==0 || a[mid-1]<a[mid]) && (mid==a.length-1 || a[mid]>a[mid+1])) return mid;
        //     else if(a[mid]<a[mid+1]) st = mid+1;    //uphill
        //     else end = mid-1;   //downhill
        // }
        return -1;
    }
    public static void main(String[] args) {
        int[] a = {1,2,1,3,5,6,4};
        System.out.println("Index of Peak Element : " + peakElement(a));
    }
}
