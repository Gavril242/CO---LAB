package testbench;


        import bench.cpu.CPUThreadedHashing;
        import logging.ILog;
        import logging.TimeUnits;
        import timing.Timer;
        import logging.ConsoleLogger;
        import timing.ITimer;

public class TestCPUThreadedHashing {

    public static void main(String[] args) {

        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        CPUThreadedHashing bench = new CPUThreadedHashing();

        int maxLength = 10;
        int nThreads = 64;
        //int hashCode = 524381996; //frodo 3 sec
        //int hashCode = 1018655712; //break 2.2  sec
        int hashCode = 132368363;//brasov 51 sec
        bench.warmup();
        timer.start();
        bench.run(maxLength, nThreads, hashCode);
        long time = timer.stop();
        TimeUnits timeUnits=TimeUnits.SECONDS;
        log.writeTime("Finished in", time, timeUnits);
        log.write("Result is", bench.getResult());
    }
}