package bench.cpu;

import bench.IBenchmark;

import java.io.DataInput;
import java.math.BigDecimal;

public class DigitsOfPi implements IBenchmark {
    /**
     * @param params the parameters needed to initialize the benchmark.
     */

    private static final BigDecimal FOUR = BigDecimal.valueOf(4);
    private static final BigDecimal ONE = BigDecimal.valueOf(1);
    private static final BigDecimal ZERO = BigDecimal.valueOf(0);
    private static final int roundingMode = BigDecimal.ROUND_HALF_EVEN;

    private BigDecimal wholenumber = new BigDecimal("0");
    private int digits;

    private BigDecimal arctan(int denominator, int scale) {
        BigDecimal result, number, term;
        BigDecimal denominatorX = BigDecimal.valueOf(denominator);
        BigDecimal denominatorX2 = BigDecimal
                .valueOf(denominator * denominator);
        number = ONE.divide(denominatorX, scale, roundingMode);
        result = number;
        int i = 1;
        do {
            number = number.divide(denominatorX2, scale, roundingMode);
            int denom = 2 * i + 1; // /3, /5 , /7 , /9
            term = number
                    .divide(BigDecimal.valueOf(denom), scale, roundingMode);
            if (i % 2 != 0) { // finds the sign between terms
                result = result.subtract(term);
            } else {
                result = result.add(term);
            }
            i++;
        } while (term.compareTo(ZERO) != 0);
        return result;
    }


    @Override
    public void initialize(Object... params) {
        digits = (Integer) params[0];
        wholenumber = new BigDecimal("0");


    }

    /**
     *
     */
    @Override
    public void run() {


        int scale = digits + 5; // for scale = digits the value of pi is
        // incorrect , the correction is performed by
        // adding 5 at scale;
        BigDecimal arctan1_5 = arctan(5, scale);
        BigDecimal arctan1_239 = arctan(239, scale);
        BigDecimal pi = arctan1_5.multiply(FOUR).subtract(arctan1_239)
                .multiply(FOUR);
        wholenumber = pi;
       //ystem.out.println( pi.setScale(digits, BigDecimal.ROUND_HALF_UP));

    }

    /**
     * @param params
     */
    @Override
    public void run(Object... params) {

    }

    public void printPi(){
        System.out.println(wholenumber.setScale(digits,BigDecimal.ROUND_HALF_UP));
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

        //nothing much

    }

    /**
     *
     */
    @Override
    public void warmup() {

        initialize(30000);
        run();


    }
}

//temporary test
class test{
    public static void main(String[] args) {
        DigitsOfPi pi = new DigitsOfPi();
        pi.warmup();
        for(int i=0; i<=10;i++) {
            pi.initialize(1000);
            pi.run();
        }
        pi.printPi();
    }
}



