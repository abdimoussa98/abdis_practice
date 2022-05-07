import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;
import java.util.Scanner;


public class fibWithAndWithoutMemoization {
    public static void main(String[] args){

    StopWatch watch = new StopWatch();
    Scanner scanner = new Scanner(System.in);

    int userInt;
    long userLong;

    watch.start();
        System.out.println("Fibonacci Brute Force!: Enter (int) nth fib number to calculate");
        userInt = scanner.nextInt();
        System.out.println("Running...");
        System.out.println("nth Fibonacci num:  " + fib(userInt));
    watch.stop();
        System.out.println("Time Elapsed: " + watch.toString() + "\n");

    watch.reset();

    watch.start();
        System.out.println("Fibonacci with Memoization: Enter (Long) nth fib number to calculate");
        userLong = scanner.nextLong();
        System.out.println("Running...");
        System.out.println("nth Fibonacci num:  " + fibWithMemo(userLong, new HashMap<>()));
    watch.stop();
        System.out.println("Time Elapsed: " + watch.toString() + "\n");

    watch.reset();

    watch.start();
        System.out.println("TriFibonacci with Memoization: Enter (Long) nth triFib number to calculate");
        userLong = scanner.nextLong();
        System.out.println("Running...");
        System.out.println("nth TriFibonacci num:  " + tribonacciWithMemo(userLong, new HashMap<Long, Long>()));
    watch.stop();
        System.out.println("Time Elapsed: " + watch.toString() + "\n");

    watch.reset();

    watch.start();
        System.out.println("TriFibonacci with Tabulation: Enter (int) nth triFib number to calculate");
        userInt = scanner.nextInt();
        System.out.println("Running...");
        System.out.println("nth TriFibonacci num:  " + tribonacciTabulation(userInt));
    watch.stop();
        System.out.println("Time Elapsed: " + watch.toString() + "\n");

    }

    /*
     * watch out for the upper and lower bounds of signed ints, probably better to do with long or unsigned int.
     * 30th fib value is 832040.
     * 45th fib value is 1134903170.
     * 50th fib value is 12586269025.
     *   Here I had to change the code from using integers to using longs since java doesn't
     *   have unsigned integers and the value is outside the upper bound of an int (2^31-1). Casting values is confusing
     *   and checking equality between wrapper class objects and primitives is also confusing. The time diff for fib() &
     *   fibWithMemo() on the 50th fib is: fib() --> 00:00:59.558 & fibWithMemo() --> 00:00:04.645. This is a significant
     *   diff when using memoization.
     * */

    public static Long fibWithMemo(Long n, HashMap<Long, Long> memo) {
        if (n == 0) return (long)0; // base case
        if (n == 1) return (long)1;
        if (memo.containsKey(n)){
            return memo.get(n);
        }
        long result = (long)fibWithMemo((n-1), memo) +  fibWithMemo((n-2), memo);
        memo.put(n, result);
        return result;
    }

    public static long fib(long n) {
        if (n == 0) return 0; // base case
        if (n == 1) return 1;

        return fib((n-1)) +  fib((n-2));
    }

    public static long tribonacciWithMemo(long n, HashMap<Long, Long> memo){
        if(n<=1) return n;

        if(n==2) return 1;

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        memo.put(n, tribonacciWithMemo(n-3, memo) + tribonacciWithMemo(n-2, memo) + tribonacciWithMemo(n-1, memo));
        return tribonacciWithMemo(n-3, memo) + tribonacciWithMemo(n-2, memo) + tribonacciWithMemo(n-1, memo);

//        /* Using a variable should only reduce the last stack calls of the unwinding */
//        long result = tribonacciWithMemo(n-3, memo) + tribonacciWithMemo(n-2, memo) + tribonacciWithMemo(n-1, memo);
//        memo.put(n, result);
//        return result;
    }

    public static int tribonacciTabulation(int n) {

        int[] result = new int[n+1];
        for(int i = 0; i <= n; i++){
            if(i < 2) result[i] = i;
            if(i == 2) result[i] = 1;

            if(i > 2) result[i] = (result[i - 3] + result[i - 2] + result[i - 1]);
        }
        return result[n];
    }

}
