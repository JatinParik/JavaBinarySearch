public class RaceTrack {
    
    static boolean isDistancePossible(int[] a, int m, int minDistance) {
        int kidsPlaced = 1;
        int position = a[0];   //position of current kid or position of last kid placed
        for(int i = 1; i<a.length; i++) {
            if((a[i]-position) >= minDistance) {
                 kidsPlaced++;
                 position = a[i];
            } 
        }
        return kidsPlaced>=m;
    }

    static int startingSpots(int[] a, int m) {
        if(a.length<m) return -1;  //Number of Starting spots are less than number of kids
        int st = 1, end = a[a.length-1]-a[0];
        int ans = 0;
        while(st<=end) {
            int mid = st + (end-st)/2;
            if(isDistancePossible(a, m, mid)) { //can we place m kids on the race track such that the minmum distance between any two kids is not less than mid
                ans = mid;
                st = mid+1;
            } else {
                end = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 8, 9};
        int m = 3;
        int ans = startingSpots(a, m);
        System.out.println("Maximum of minimum distance between two kids : " + ans);
    }
}
