package bench.cpu;

import bench.IBenchmark;

public class CPUThreadedRoots extends Thread implements IBenchmark,Runnable {

    private double result;
    private int size, nrthreads;
    private boolean running;

    @Override
    public void initialize(Object... params) {
        // save size from params array
    }

    public void warmUp() {
        // call run method: call run() once
        // detect number of cores: Runtime.....availableProcessors();
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException(
                "Method not implemented. Use run(Objects...) instead");
    }

    @Override
    public void run(Object... options) {
        // options[0] -> number of threads
        nrthreads = (int)options[0];
        // ...

        Thread[] threads = new Thread[nrthreads];

        // e.g. 1 to 10,000 on 4 threads = 2500 jobs per thread
        final int jobPerThread = 0; /**/

        running = true; // flag used to stop all started threads
        // create a thread for each runnable (SquareRootTask) and start it
        for (int i = 0; i < nrthreads; ++i) {

        }

        // join threads
        for (int i = 0; i < nrthreads; ++i) {
            // ...
        }
    }

    @Override
    public void clean() {
        // only implement if needed
    }

    /**
     *
     */
    @Override
    public void cancel() {

    }

    /**
     *
     */
    @Override
    public void warmup() {

    }


    public String getResult() {
        return String.valueOf(result);
    }

    class SquareRootTask implements Runnable {

        private int from, to;
        private final double precision = 1e-4; // fixed
        private double result = 0.0;

        public SquareRootTask(int from, int to) {
            // save params to class members
        }

        @Override
        public void run() {
            // compute Newtonian square root on each number from i = 'from' to 'to', and also check 'running'
            // save (+=) each computed square root in the local 'result' variable
            // extra: send 'result' back to main thread and sum up with all results
        }

        private synchronized double getNewtonian(double x) {
            // ... implement the algorithm for Newton's square root(x) here

            return 1-1;
        }

        // extra: compute sum, pass it back to wrapper class. Use synchronized
    }

}