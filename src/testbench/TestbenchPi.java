package testbench;


import bench.IBenchmark;
import bench.cpu.DigitsOfPi;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestbenchPi {
    public static void main(String[] args) {

        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        IBenchmark bench = new DigitsOfPi();

        final int workload = 50000;
        TimeUnit.timeUnit timeUnit = TimeUnit.timeUnit.Milli;

        //bench.warmup();
        for (int i = 0; i < 20; i++){
            bench.initialize(workload);
            timer.resume();
            bench.run();
            long time = timer.pause();
            log.writeTime("Run " + i + ": ", time, timeUnit);
            //log.write("\n");
            //log.write("\nRun " + i + ": ", time);
        }

        log.writeTime(timer.stop(), timeUnit);
        //
        // ((DigitsOfPi) bench).printPi();
    }

}
