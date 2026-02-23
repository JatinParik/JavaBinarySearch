public class Search2DMatrix2 {

    static boolean search(int[][] a, int target) {
        int r = a.length;
        int c = a[0].length;
        int i = 0, j = c-1;
        while(i<r && j >=0) {
            if(target==a[i][j]) return true;
            else if(target<a[i][j]) j--;  //move left
            else i++;   //move down
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] a = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int r = a.length;
        int c = a[0].length;
        int target = 20;
        System.out.println(search(a, target));
    }
}
