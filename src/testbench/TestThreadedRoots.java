package testbench;

import bench.IBenchmark;
import bench.cpu.CPUThreadedRoots;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnits;
import timing.Timer;

public class TestThreadedRoots {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimeUnits timeUnits = TimeUnits.NANOSECONDS;
        ILog log = new ConsoleLogger();
        CPUThreadedRoots bench = new CPUThreadedRoots();



        int workload = 35000000;


        bench.initialize(workload);
        bench.warmup();

        for(int i = 1; i <= 64; i *= 2) {
            timer.start();
            bench.run(i);
            long time = timer.stop();
            double score = (double) workload / (time * 10E-6 * i);

            log.writeTime("Time ", time, TimeUnits.NANOSECONDS);
            log.write("The score for run " + i + " is: " + score);
            log.write("\n");
        }

        double result = Double.parseDouble(((CPUThreadedRoots)bench).getResult());

    }
}