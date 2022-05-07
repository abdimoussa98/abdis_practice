import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;
import java.util.Scanner;


public class fibWithAndWithoutMemoization {
    public static void main(String[] args){

    /*
    * watch out for the upper and lower bounds of signed ints, probably better to do with long or unsigned int.
    * 30th fib value is 832040.
    * 45th fib value is 1134903170.
    * 50th fib value is 12586269025.
    *   Here I had to change the code from using integers to using longs since java doesn't
    *   have unsigned integers and the value is outside the upper bound of an int (2^31-1). Casting values is confusing
    *   and checking equality between wrapper class objects and primitives is also confusing. The time diff for the 50th
    *   fib is: Time Elapsed for SLOW algo: 00:00:59.558 & Time Elapsed for FAST algo: 00:00:04.645. This is a
    *   significant diff when using memoization.
     * */


    StopWatch watch = new StopWatch();
    Scanner scanner = new Scanner(System.in);

    int userInt;
    long userLong;

    watch.start();
        System.out.println("Without Memoization: Enter nth fib number to calculate");
        userInt = scanner.nextInt();
        System.out.println("Slow Algo:  " + fib(userInt));
    watch.stop();
        System.out.println("Time Elapsed for SLOW algo: " + watch.toString() + "\n");

    watch.reset();

    watch.start();
        System.out.println("With Memoization: Enter nth fib number to calculate");
        userLong = scanner.nextLong();
        System.out.println("Fast Algo:  " + fibWithMemo(userLong, new HashMap<>()));
    watch.stop();
        System.out.println("Time Elapsed for FAST algo: " + watch.toString() + "\n");


    }
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
}
