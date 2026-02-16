import java.util.Scanner;

public class SquareRootOfANumberUptoPPrecisions {
    
    static double sqrt(double n, int p) {
       double st = 0, end = Math.max(1, n);
       //  Math.max(1,n) will do the same as :
       //  if(n<1) end = 1;
       //  else end = n;
       double mid = st + (end-st)/2;
       double eps = Math.pow(10, -p);
       while(Math.abs(mid*mid-n)>eps) {
        mid = st + (end-st)/2;
        double val = mid*mid;
        if(val<=n) st = mid;
        else end = mid;
       }
       return mid;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        double n = sc.nextDouble();
        System.out.print("Enter number of decimal digits : ");
        int p = sc.nextInt();
        double ans = sqrt(n, p);
        System.out.printf("Square root of given number upto given number of decimal places : " + "%." + p + "f", ans);
    }
}
