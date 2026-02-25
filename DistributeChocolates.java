public class DistributeChocolates {
    
    static boolean isDistributionPossible(int[] a, int m, int maxChocolates) {
        int numOfStudents = 1;
        int chocolates = 0;   //Number of chocolates the current student have
        for(int i = 0; i<a.length; i++) {
            if(a[i]>maxChocolates) return false;
            if((chocolates+a[i]) <= maxChocolates) {
                chocolates += a[i];
            } else {
                numOfStudents++;
                chocolates = a[i];
            }
        }
        return numOfStudents<=m;
    }

    static int distributeChocolates(int[] a, int m) {
        if(a.length<m) return -1;   //Distribution not possible
        int st = 1, end = (int)1e9;
        int ans = 0;
        while(st<=end) {
            int mid = st + (end-st)/2;
            if(isDistributionPossible(a, m, mid)) {
                ans = mid;
                end = mid-1;
            } else {
                st = mid+1;
            } 
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] a = {12, 34, 67, 90};
        int m = 2;
        System.out.println("Minimum possible number of maximum chocolate distribution to a student : " + distributeChocolates(a, m));
    }
}
