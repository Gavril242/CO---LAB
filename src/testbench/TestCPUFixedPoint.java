package testbench;

import bench.IBenchmark;
import bench.SleepBenchmark;
import bench.cpu.CPUFixedPoint;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestCPUFixedPoint {

    public static void main(String[] args) {
        double MOPS;
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        IBenchmark bench = new CPUFixedPoint();

        final long workload = 1000567600;
        TimeUnit timeUnit;
        timeUnit = new TimeUnit();
        bench.initialize(workload);
        timer.resume();
        try{
        bench.run();}catch(Exception e){e.printStackTrace();}
        long time = timer.pause();
        log.writeTime("Time ", time, TimeUnit.timeUnit.Nano);
        //log.write("Run " + i + ": ", time);
        //log.writeTime(timer.stop(), timeUnit);
       // time = (long) (time * Math.pow(10, -9));
        MOPS = (double)(29 * workload)/(1000000 * (time * Math.pow(10, -9)));
        System.out.println("MOPS: " +  MOPS);
        /* timer.start();
        bench.run();
        long time = timer.stop();

        log.write("Finished in", time, "ns");*/
        //log.close();
        //bench.clean();
    }
}
