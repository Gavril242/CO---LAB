package testbench;

import bench.DemoBenchmark;
import bench.IBenchmark;
import logging.ILog;
import timing.Timer;
import logging.ConsoleLogger;
import timing.ITimer;
import logging.TimeUnit;

public class Testbench {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        IBenchmark bench = new DemoBenchmark();

        final int workload = 10000;
        TimeUnit.timeUnit timeUnit = TimeUnit.timeUnit.Milli;
        bench.initialize(workload);
        for (int i = 0; i < 12; i++){
            timer.resume();
            bench.run();
            long time = timer.pause();
            log.writeTime("\nRun " + i + ": ", time, timeUnit);
            log.write("\n");
            //log.write("\nRun " + i + ": ", time);
        }
        log.writeTime(timer.stop(), timeUnit);
    }

}
