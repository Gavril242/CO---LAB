package bench;

public class DummyBenchmark implements IBenchmark {
    /*
     *
     *
     *
     * */
    @Override
    public void run() {

    }

    @Override
    public void initialize(Object ...params) {

        System.out.println("DummyBenchmark initialized");

    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }
}
