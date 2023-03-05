package testbench;

import bench.*;
import timing.*;
import logging.*;

public class TestBench {

    ITimer timer = new Timer();
    ILog log = new ConsoleLogger();

    IBenchmark benchh = new DummyBenchmark();


         benchh.initialize(2387482374);


    //Homework implementation Timer, ConsoleLogger, FileLogger





}
