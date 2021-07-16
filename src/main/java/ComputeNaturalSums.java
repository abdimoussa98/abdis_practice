import com.google.common.base.Stopwatch;
import org.apache.commons.lang3.time.StopWatch;

public class ComputeNaturalSums {


    public static void main(String args[]) {

    StopWatch watch = new StopWatch();

    watch.start(); // start watch for slow algo
    System.out.println("Sum = " + findSum(100000000000L));
    watch.stop();
    System.out.println("Time Elapsed for SLOW algo: " + watch.toString());

    watch.reset();
    watch.start(); // start watch for fast algo
    System.out.println("Sum = " + quickSum(100000000000L));
    watch.stop();
    System.out.println("Time Elapsed for FAST algo: " + watch.toString());

    };

    public static long findSum(long N) {
    /*this compute the sum of the first natural nums from 1 to N
        by looping through every value adding one by one
     */

        long sum = 0;
        for (long v = 1; v <= N ; v++) {
            sum += v;
        }
        return sum;
    };

   public static long quickSum(long N) {
   /*this compute the sum of the first natural nums from 1 to N
        by using this formula (N * (N + 1) / 2)
     */
    return (N * (N + 1) / 2);
};
}