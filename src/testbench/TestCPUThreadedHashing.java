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
        int nThreads = 16;// useless for now
        //int hashCode = 524381996; //frodo 1.088 sec
        //int hashCode = 52703576; //airbnb 5.527  sec
        //int hashCode = 605107138;  //brasov 11.67 sec
        //int hashCode = 1018655712;  //break 0.47 sec
        int hashCode = 317266982;  //direct 18.77 sec
        bench.warmup();
        timer.start();
        bench.run(maxLength, nThreads, hashCode);
        long time = timer.stop();
        TimeUnits timeUnits=TimeUnits.SECONDS;
        log.writeTime("Finished in", time, timeUnits);
        log.write("Result is", bench.getResult());
    }
}