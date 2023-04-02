package bench.cpu;

import bench.IBenchmark;

public class CPUREC implements IBenchmark {
    /**
     *
     */
    private long size, prime;
    private int count;
    @Override
    public void run() {

    }

        /**
         * @param params
         */
        @Override
        public void run(Object... params) {
                long x;
                if((boolean) params[0] == false){
                        x = recursive(1, size, 0);
                }
                else{
                        long sum;
                        sum = recursiveUnrolled(1, (int) params[1], size, 0);

                }

        }

        /**
 * @param params
 */
@Override
public void initialize(Object... params) {
        size = (long)params[0];
        }

/**
 *
 */
@Override
public void clean() {

        }

/**
 *
 */
@Override
public void cancel() {

        }

/**
 *
 */
@Override
public void warmup() {

        }

private long recursive(long start, long size, int counter) {
        if (start > size) {
        //System.out.println("Reached nr " + start + "/" + size + " after " + counter + " calls.");
               // System.out.println("Didnt crash");
        return 0;
        }
        try {
        if (isPrime(start)) {
        this.prime = start;
        this.count = counter;
        return start + recursive(start + 1, size, counter + 1);
        } else {
        return recursive(start + 1, size, counter + 1);
        }
        } catch (StackOverflowError e) {
                e.printStackTrace();
        //System.out.println("Reached nr " + start + "/" + size + " after " + counter + " calls.");
        return 0;
        } catch (NoClassDefFoundError e) {
        System.out.println("Reached nr " + start + "/" + size + " after " + counter + " calls.");
        return 0;
        }
        }

private long recursiveUnrolled(long start, int unrollLevel, long size, int counter) {
        if (start > size) {
        //System.out.println("Reached nr " + start + "/" + size + " after " + counter + " calls.");
               // System.out.println("Didnt crash");
        return 0;
        }
        long sum = 0;
        for (int i = 0; i < unrollLevel; i++) {
        if (isPrime(start)) {
        this.prime = start;
        this.count = counter;
        sum += start;
        }
        start++;
        }
        try {
        sum += recursiveUnrolled(start, unrollLevel, size, counter + 1);
        } catch (StackOverflowError e) {
        //System.out.println("Reached nr " + start + "/" + size + " after " + counter + " calls.");
        return 0;
        } catch (NoClassDefFoundError e) {
                //e.printStackTrace();
        //System.out.println("Reached nr " + start + "/" + size + " after " + counter + " calls.");
        return 0;

        }finally {
               // System.out.println("Did crash");
        }
        //System.out.println("Did crash");
        return sum;
        }

private boolean isPrime(long x){
        if (x <= 2)
        return true;
        for (int i = 2; i <= Math.sqrt(x); i++) {
        if (x % i == 0)
        return false;
        }
        return true;
        }

public long getPrime(){
        return this.prime;
        }

public int getCount(){
        return this.count;
        }

        }
