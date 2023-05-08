package testbench;


import bench.IBenchmark;
import bench.cpu.DigitsOfPi;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnits;
import timing.ITimer;
import timing.Timer;

public class TestbenchPi {
    public static void main(String[] args) {

        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        IBenchmark bench = new DigitsOfPi();

        final int workload = 50000;
        TimeUnits timeUnits = TimeUnits.MILLISECONDS;

        //bench.warmup();
        for (int i = 0; i < 20; i++){
            bench.initialize(workload);
            timer.resume();
            bench.run();
            long time = timer.pause();
            log.writeTime("Run " + i + ": ", time, timeUnits);
            //log.write("\n");
            //log.write("\nRun " + i + ": ", time);
        }

        log.writeTime(timer.stop(), timeUnits);
        //
        // ((DigitsOfPi) bench).printPi();
    }

}
