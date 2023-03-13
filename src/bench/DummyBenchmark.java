package bench;

public class DummyBenchmark implements IBenchmark {
    /*
     *
     *
     *
     * */

    public void run() {

    }


    public void initialize(Object ...params) {

        System.out.println("DummyBenchmark initialized");

    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    /**
     *
     */
    @Override
    public void warmup() {

    }
}
