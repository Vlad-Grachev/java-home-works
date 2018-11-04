package hw3;

public class FactorialTest {
    static long lpFactorial(long n){
        long result = 1;
        for (long i = 2; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    static long rcFactorial(long n){
        if(n > 1)
            return rcFactorial(n -1) * n;
        else
            return 1;
    }

    public static void main(String[] args) {
        long f1, f2;
        long startTime = System.nanoTime();
        f1 = lpFactorial(20);
        long lpTime = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        f2 = rcFactorial(20);
        long rcTime = System.nanoTime() - startTime;
        if(f1 == f2)
            System.out.println("Results are equal");
        if(lpTime > rcTime)
            System.out.println("Recursion factorial is faster");
        else
            System.out.println("Loop factorial is faster");
    }
}
