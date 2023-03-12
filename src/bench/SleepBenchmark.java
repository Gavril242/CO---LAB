package bench;

import logging.ConsoleLogger;
import logging.ILog;
import timing.ITimer;
import timing.Timer;

public class SleepBenchmark implements IBenchmark{

    public int n;

    @Override
    public void run() {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(Object... params) {
        n = (int) params[0];
    }


    @Override
    public void clean() {

    }

    @Override
    public void cancel() {
        System.out.println("cancelling");
    }


}

class SleepTest{
    public static void main(String[] args){
        ITimer timer = new Timer();
        IBenchmark bench = new SleepBenchmark();
        ILog log = new ConsoleLogger();

        bench.initialize(10);
        timer.start();
        bench.run();
        long time = timer.stop();

        long offset = (long) (100 * (time - (((SleepBenchmark) bench).n)*Math.pow(10, 6)) / ((((SleepBenchmark) bench).n)*Math.pow(10, 6)));

        log.write("Given value: ", ((SleepBenchmark) bench).n, "ms");
        log.write("Finished after", time, "ns");
        log.write("Offset is", offset, "%");

    }
}
