package testbench;

import bench.*;
import timing.*;
import logging.*;

public class TestBench {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        IBenchmark benchmark = new DemoBenchmark();
        benchmark.initialize();
        timer.start();
        benchmark.run();
        System.out.println("\nTime has elapsed: ");
        log.write(timer.stop());
        System.out.print("ns");
        benchmark.clean();


        benchmark.initialize();
        long totaltime = 0;
        for (int i = 0; i < 100; i++) {
            timer.resume();
            benchmark.run();
            if(i==99){totaltime = timer.stop(); break;}
            long time = timer.pause();
            log.write("Run "+i+": "+time);
        }
        log.write("Total time passed: "+totaltime);




    }







    //Homework implementation Timer, ConsoleLogger, FileLogger





}
