package testbench;
import java.math.BigDecimal;

import bench.IBenchmark;
import bench.cpu.CPUREC;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

import static java.lang.Math.log;

public class TestCPURecursionLoopUnrolling {



    public static void main(String[] args) {






        double MOPS, score;
        long prime;
        int count;
        double Score;

        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        IBenchmark bench = new CPUREC();
        timer.start();
        long workload =0;


         if (workload==0) workload =100;


        try {


            if (workload==0) workload =100;

            bench.initialize(workload);
            workload =Long.parseLong(args[0]);
           // System.out.println(args[0]);
            //System.out.println(args[1]);
           // System.out.println(args[2]);
        }catch(Exception e) {}
        bench.initialize(workload);

        for(int i=0; i<100; i++) {


            bench.run(false);
        }
        long time = timer.pause();
        prime = ((CPUREC) bench).getPrime();
        count = ((CPUREC) bench).getCount();
        System.out.println("workload="+workload);
        log.writeTime("Time ", time, TimeUnit.timeUnit.Milli);


        Score =  ((workload*100/(time/1000)*prime)*prime/count)/1000;
        score = (( Score - 0) / (1000000 - 0)) * (10000 - 0) + 10;
        System.out.println("For unrolling 0(recursive) Reached prime number " + prime + " after " + count + " calls and the score is: "+score);

        timer.start();
        bench.initialize(workload);
        for(int i=0; i<100; i++) {


            bench.run(true,2);
        }
        time = timer.pause();
        prime = ((CPUREC) bench).getPrime();
        count = ((CPUREC) bench).getCount();

        log.writeTime("Time ", time, TimeUnit.timeUnit.Milli);
        Score =  ((workload*100/(time/1000)*prime)*prime/count)/1000;
        score = (( Score - 0) / (1000000 - 0)) * (10000 - 0) + 10;
        System.out.println("For unrolling 0 Reached prime number " + prime + " after " + count + " calls and the score is: "+score);


        timer.start();
        bench.initialize(workload);
        for(int i=0; i<100; i++) {


            bench.run(true,5);
        }
        time = timer.pause();
        prime = ((CPUREC) bench).getPrime();
        count = ((CPUREC) bench).getCount();

        log.writeTime("Time ", time, TimeUnit.timeUnit.Milli);

        Score =  ((workload*100/(time/1000)*prime)*prime/count)/1000;
        score = (( Score - 0) / (1000000 - 0)) * (10000 - 0) + 10;
        System.out.println("For unrolling 5 Reached prime number " + prime + " after " + count + " calls and the score is: "+score);


        timer.start();
        bench.initialize(workload);
        for(int i=0; i<100; i++) {


            bench.run(true,10);
        }
        time = timer.pause();
        prime = ((CPUREC) bench).getPrime();
        count = ((CPUREC) bench).getCount();

        log.writeTime("Time ", time, TimeUnit.timeUnit.Milli);

        Score =  ((workload*100/(time/1000)*prime)*prime/count)/1000;
        score = (( Score - 0) / (1000000 - 0)) * (10000 - 0) + 10;
        System.out.println("For unrolling 10 Reached prime number " + prime + " after " + count + " calls and the score is: "+score);



        //MOPS = (double)(29 * workload)/(1000000 * (time * Math.pow(10, -9)));
        //System.out.println("MOPS: " +  MOPS);


    }
}
