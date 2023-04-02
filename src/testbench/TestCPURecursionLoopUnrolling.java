package testbench;
import java.math.BigDecimal;

import bench.IBenchmark;
import bench.cpu.CPUREC;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestCPURecursionLoopUnrolling {



    public static void main(String[] args) {

        double MOPS, score;
        long prime;
        int count;
        long Score;

        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        IBenchmark bench = new CPUREC();
        timer.start();
        final long workload = 20000;
        bench.initialize(workload);


        for(int i=0; i<100; i++) {


            bench.run(false);
        }
        long time = timer.pause();
        prime = ((CPUREC) bench).getPrime();
        count = ((CPUREC) bench).getCount();

        log.writeTime("Time ", time, TimeUnit.timeUnit.Milli);
        double A = 1000000.0 / ((time / 100.0) * (workload / (double) count) * (1 + 1.0/2.0) * (1 - 0.0001 * prime));
        long B = (long) A;
        Score = (A - B >= 0.5) ? B + 1 : B;
        score = 1000 * (1 / (time / workload));

        System.out.println("Reached prime number " + prime + " after " + count + " calls and the score is: "+Score);


        timer.start();
        bench.initialize(workload);
        for(int i=0; i<100; i++) {


            bench.run(true,2);
        }
        time = timer.pause();
        prime = ((CPUREC) bench).getPrime();
        count = ((CPUREC) bench).getCount();

        log.writeTime("Time ", time, TimeUnit.timeUnit.Milli);
        Score = (long) (1000000.0 / ((time / 100.0) * (workload / (double) count) * (1 + 1.0/2.0) * (1 - 0.0001 * prime)));
        score = 1000 * (1 / (time / workload));
        System.out.println("Reached prime number " + prime + " after " + count + " calls and the score is: "+Score);


        timer.start();
        bench.initialize(workload);
        for(int i=0; i<100; i++) {


            bench.run(true,5);
        }
        time = timer.pause();
        prime = ((CPUREC) bench).getPrime();
        count = ((CPUREC) bench).getCount();

        log.writeTime("Time ", time, TimeUnit.timeUnit.Milli);
        Score = (long) (1000000.0 / ((time / 100.0) * (workload / (double) count) * (1 + 1.0/2.0) * (1 - 0.0001 * prime)));
        score = 1000 * (1 / (workload/time+1*10000));
        System.out.println("Reached prime number " + prime + " after " + count + " calls and the score is: "+score);


        timer.start();
        bench.initialize(workload);
        for(int i=0; i<100; i++) {


            bench.run(true,10);
        }
        time = timer.pause();
        prime = ((CPUREC) bench).getPrime();
        count = ((CPUREC) bench).getCount();

        log.writeTime("Time ", time, TimeUnit.timeUnit.Milli);

        Score = (long) (1000000.0 / ((time / 100.0) * (workload / (double) count) * (1 + 1.0/2.0) * (1 - 0.0001 * prime)));
        score = 1000 * (1 / (time / workload));

        System.out.println("Reached prime number " + prime + " after " + count + " calls and the score is: "+Score);



        //MOPS = (double)(29 * workload)/(1000000 * (time * Math.pow(10, -9)));
        //System.out.println("MOPS: " +  MOPS);


    }
}
