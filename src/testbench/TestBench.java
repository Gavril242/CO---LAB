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





    }







    //Homework implementation Timer, ConsoleLogger, FileLogger





}
